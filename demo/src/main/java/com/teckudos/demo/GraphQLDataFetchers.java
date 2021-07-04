package com.teckudos.demo;

import com.google.common.collect.ImmutableMap;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class GraphQLDataFetchers {
    private static List<Map<String, String>> users = Arrays.asList(
            ImmutableMap.of("id", "0",
                    "name", "Vikas Sharma",
                    "age", "25",
                    "organizationId", "teckudos"),
            ImmutableMap.of("id", "1",
                    "name", "Abhimanyu",
                    "age", "20",
                    "organizationId", "breakthewall")
    );

    private static List<Map<String, String>> organizations = Arrays.asList(
            ImmutableMap.of("id", "teckudos",
                    "name", "Teckudos"),
            ImmutableMap.of("id", "breakthewall",
                    "name", "BreakTheWall")
    );

    public DataFetcher getUserById() {
        return dataFetchingEnvironment -> {
            String userId = dataFetchingEnvironment.getArgument("id");
            return users
                    .stream()
                    .filter(user -> user.get("id").equals(userId))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher getOrganizationDataFetcher() {
        return dataFetchingEnvironment -> {
            Map<String, String> user = dataFetchingEnvironment.getSource();
            String organizationId = user.get("organizationId");
            return organizations
                    .stream()
                    .filter(organization -> organization.get("id").equals(organizationId))
                    .findFirst()
                    .orElse(null);
        };
    }
}
