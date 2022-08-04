package com.ultralesson.gorestapitests.Users.getAll;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class GetAllUsersResponse {

    @Setter
    private int statusCode;

    @JsonProperty("data")
    private List<Data> dataList;
    private Meta meta;

    public boolean hasMaleUser() {
        return dataList.stream()
                .filter(data -> data.getGender().equals("male"))
                .findFirst()
                .isPresent();
    }

    @Getter
    public static class Meta{
        private Pagination pagination;
    }

    @Getter
    public static class Pagination{
        private String total;
        private String pages;
        private String limit;
        private Links links;
        private String page;
    }
    @Getter

    public static class Links{
        private String next;
        private String current;
        private String previous;
    }

    @Getter
    public static class Data{
        private String gender;
        private String name;
        private String id;
        private String email;
        private String status;
    }
}
