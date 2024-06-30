package io.getarrays.server.repo;

import io.getarrays.server.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepo extends JpaRepository<Server, Long> {
    Server findByIpAddress(String ipAddress); // ES importante colocar bien el nombre (al colocar find JPA hace un select con el nombre que va después del by)

}
