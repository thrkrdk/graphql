package com.graphql.springboot.graphql.context;

import com.graphql.springboot.da.entity.Role;
import com.graphql.springboot.service.IRoleService;
import graphql.kickstart.execution.context.DefaultGraphQLContext;
import graphql.kickstart.execution.context.GraphQLContext;
import graphql.kickstart.servlet.context.DefaultGraphQLServletContext;
import graphql.kickstart.servlet.context.DefaultGraphQLWebSocketContext;
import graphql.kickstart.servlet.context.GraphQLServletContextBuilder;
import lombok.RequiredArgsConstructor;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoader;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import javax.websocket.server.HandshakeRequest;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CustomGraphQLContextBuilder implements GraphQLServletContextBuilder {
    private final IRoleService roleService;


    @Override
    public GraphQLContext build(HttpServletRequest req, HttpServletResponse response) {
        return DefaultGraphQLServletContext.createServletContext(buildDataLoaderRegistry(), null)
                .with(req).with(response)
                .build();
    }

    @Override
    public GraphQLContext build() {
        return new DefaultGraphQLContext(buildDataLoaderRegistry(), null);
    }

    @Override
    public GraphQLContext build(Session session, HandshakeRequest request) {
        return DefaultGraphQLWebSocketContext.createWebSocketContext(buildDataLoaderRegistry(), null)
                .with(session)
                .with(request).build();
    }

    private DataLoaderRegistry buildDataLoaderRegistry() {
        DataLoaderRegistry dataLoaderRegistry = new DataLoaderRegistry();

        MappedBatchLoader<Long, List<Role>> userMappedBatchLoader =
                userIds -> CompletableFuture.supplyAsync(() -> {
                    List<Role> customers = roleService.findByUser_IdIn(userIds);
                    return customers.stream().collect(Collectors.groupingBy(roles -> roles.getUser().getId()));
                }, new SyncTaskExecutor());


        dataLoaderRegistry.register("userRoleDataLoader",
                DataLoader.newMappedDataLoader(userMappedBatchLoader));
        return dataLoaderRegistry;
    }

}
