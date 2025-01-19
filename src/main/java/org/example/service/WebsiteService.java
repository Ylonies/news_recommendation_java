package org.example.service;

import org.example.entity.Response;
import org.example.entity.User;
import org.example.entity.Website;
import org.example.repository.MockWebsiteRepository;
import org.example.repository.WebsiteRepository;
import spark.Request;

import java.util.ArrayList;
import java.util.List;

public class WebsiteService {
    private WebsiteRepository websiteRepository = new MockWebsiteRepository();

    private User getCurrentUser (Request request) {
        return request.session().attribute("currentUser ");
    }

    public Response<List<String>> getBasicWebsites() {
        List<Website> websites = websiteRepository.getBasicWebsites();
        List<String> names = new ArrayList<>();
        try {
            for (Website website : websites) {
                names.add(website.getUrl()); // Изменено на getUrl()
            }
            return new Response<>(200, names);
        } catch (Exception e) {
            return new Response<>(500);
        }
    }

    public Response<List<String>> getUserWebsites(Request request) {
        User currentUser  = getCurrentUser (request);
        List<Website> websites = websiteRepository.getUserWebsites(currentUser .getId());
        List<String> names = new ArrayList<>();
        try {
            for (Website website : websites) {
                names.add(website.getUrl()); // Изменено на getUrl()
            }
            return new Response<>(200, names);
        } catch (Exception e) {
            return new Response<>(500, "Internal Error");
        }
    }

    public Response<Website> getByName(Request request, String name) {
        User currentUser  = getCurrentUser (request);
        if (!websiteRepository.addedByName(currentUser.getId(), name)) {
            return new Response<>(409, "There is no website with this name"); // Conflict
        }
        try {
            Website website = websiteRepository.getByName(currentUser.getId(), name);
            return new Response<>(200, website);
        } catch (Exception e) {
            return new Response<>(500);
        }
    }

    public Response<Website> addToUser(Request request, String name) {
        User currentUser  = getCurrentUser (request);
        if (websiteRepository.addedByName(currentUser.getId(), name)) {
            return new Response<>(409, "Website is already added"); // Conflict
        }
        try {
            Website website = websiteRepository.addToUser(currentUser.getId(), name);
            return new Response<>(200, website);
        } catch (Exception e) {
            return new Response<>(500);
        }
    }

    //TODO delete
}