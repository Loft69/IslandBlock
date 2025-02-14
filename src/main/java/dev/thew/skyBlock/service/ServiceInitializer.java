package dev.thew.skyBlock.service;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public final class ServiceInitializer {

    public static final List<Service> services = new ArrayList<>();

    public static void registerService(Service service) {
        services.add(service);
    }

    public static void initializeServices() {
        services.forEach(ServiceInitializer::initializeService);
    }

    public static void shutdownServices() {
        services.forEach(ServiceInitializer::shutdownService);
    }

    public static void initializeService(@NonNull Service service) {
        service.load();
    }

    public static void shutdownService(@NonNull Service service) {
        service.shutdown();
    }

}
