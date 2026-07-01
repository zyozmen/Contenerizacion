package com.zyozmen.products.adapter.in.graphql;

import com.zyozmen.products.domain.exception.ResourceNotFoundException;
import com.zyozmen.products.domain.exception.ServiceUnavailableException;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.Map;

@ControllerAdvice(annotations = Controller.class)
public class ProductGraphqlExceptionHandler {

    @GraphQlExceptionHandler(ResourceNotFoundException.class)
    public GraphQLError handleResourceNotFound(ResourceNotFoundException ex, DataFetchingEnvironment env) {
        return GraphqlErrorBuilder.newError(env)
                .message(ex.getMessage())
                .extensions(Map.of(
                        "code", "NOT_FOUND",
                        "status", 404,
                        "error", "Not Found"
                ))
                .build();
    }

    @GraphQlExceptionHandler(ServiceUnavailableException.class)
    public GraphQLError handleServiceUnavailable(ServiceUnavailableException ex, DataFetchingEnvironment env) {
        return GraphqlErrorBuilder.newError(env)
                .message(ex.getMessage())
                .extensions(Map.of(
                        "code", "SERVICE_UNAVAILABLE",
                        "status", 503,
                        "error", "Service Unavailable"
                ))
                .build();
    }

    @GraphQlExceptionHandler(Exception.class)
    public GraphQLError handleGenericException(Exception ex, DataFetchingEnvironment env) {
        return GraphqlErrorBuilder.newError(env)
                .message("Ocurrió un error inesperado en el servidor")
                .extensions(Map.of(
                        "code", "INTERNAL_SERVER_ERROR",
                        "status", 500,
                        "error", "Internal Server Error"
                ))
                .build();
    }
}
