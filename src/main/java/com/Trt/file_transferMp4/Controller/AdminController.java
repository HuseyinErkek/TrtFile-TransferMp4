package com.Trt.file_transferMp4.Controller;

import com.Trt.file_transferMp4.Dto.AccesRequestDto;
import com.Trt.file_transferMp4.Dto.FileUploadLogDto;
import com.Trt.file_transferMp4.Dto.ServerAccessDto;
import com.Trt.file_transferMp4.Entity.Server;
import com.Trt.file_transferMp4.Entity.User;
import com.Trt.file_transferMp4.repository.UserRepository;
import com.Trt.file_transferMp4.service.AccessRequestService;
import com.Trt.file_transferMp4.service.ServerService;
import com.Trt.file_transferMp4.service.UserService;
import com.Trt.file_transferMp4.service.impl.FileUploadLogServiceImpl;
import com.Trt.file_transferMp4.service.impl.ServerAccessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private FileUploadLogServiceImpl fileUploadLogService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccessRequestService accessRequestService;
    @Autowired
    private ServerAccessServiceImpl serverAccessService;
    @Autowired
    private ServerService serverService;
    @Autowired
    private UserService userService;

    // File logları görüntülemek için olan kısım
    @GetMapping("/logs")
    public ResponseEntity<List<FileUploadLogDto>> getAllLogs() {
        List<FileUploadLogDto> logs = fileUploadLogService.findAllLogs();
        return ResponseEntity.ok(logs);
    }

    // Kullanıcı ID'sine göre logları getirme
    @GetMapping("/logs/user/{userId}")
    public ResponseEntity<List<FileUploadLogDto>> getLogsByUser(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId);
        List<FileUploadLogDto> logs = fileUploadLogService.findLogsByUser(user);
        return ResponseEntity.ok(logs);
    }

    // Log silme
    @DeleteMapping("/logs/{username}")
    public ResponseEntity<Void> deleteLog(@PathVariable String username) {
        fileUploadLogService.deleteLogByUsername(username);
        return ResponseEntity.noContent().build();
    }

    // Erişim Taleplerini Listeleme
    @GetMapping("/access-requests")
    public ResponseEntity<List<AccesRequestDto>> getAllAccessRequests() {
        List<AccesRequestDto> accessRequestDtos = accessRequestService.getAllAccessRequests();
        return ResponseEntity.ok(accessRequestDtos);
    }

    // Tüm sunucu erişim izinlerini listeleme
    @GetMapping("/server-accesses")
    public ResponseEntity<List<ServerAccessDto>> getAllServerAccesses() {
        List<ServerAccessDto> serverAccesses = serverAccessService.getAllServerAccesses();
        return ResponseEntity.ok(serverAccesses);
    }

    // Kullanıcı adına göre sunucu erişim izinlerini getirme
    @GetMapping("/server-accesses/user/{username}")
    public ResponseEntity<List<ServerAccessDto>> getServerAccessesByUsername(@PathVariable String username) {
        List<ServerAccessDto> serverAccesses = serverAccessService.getServerAccessesByUserId(username);
        return ResponseEntity.ok(serverAccesses);
    }

    // Sunucu erişim iznini güncelleme
    @PutMapping("/server-accesses/update/{username}")
    public ResponseEntity<Void> updateServerAccess(@PathVariable String username, @RequestParam boolean approved) {
        serverAccessService.updateServerAccess(username, approved);
        return ResponseEntity.noContent().build();
    }

    // Sunucu erişim iznini silme
    @DeleteMapping("/server-accesses/delete/{username}")
    public ResponseEntity<Void> deleteServerAccessByUsername(@PathVariable String username) {
        serverAccessService.deleteServerAccessByUsername(username);
        return ResponseEntity.noContent().build();
    }

    // Tüm sunucuları listeleme
    @GetMapping("/servers")
    public ResponseEntity<List<Server>> getAllServers() {
        List<Server> servers = serverService.getAllServers();
        return ResponseEntity.ok(servers);
    }

    // Sunucuyu isme göre getirme
//    @GetMapping("/servers/{serverName}")
//    public ResponseEntity<Server> getServerByName(@PathVariable String serverName) {
//        Optional<Server> server = serverService.getServerByName(serverName);
//        return server.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }

    // Sunucu ekleme
    @PostMapping("/servers")
    public ResponseEntity<Server> addServer(@RequestBody Server server) {
        try {
            Server newServer = serverService.addServer(server);
            return ResponseEntity.ok(newServer);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Sunucuyu isme göre silme
    @DeleteMapping("/servers/{serverName}")
    public ResponseEntity<Void> deleteServerByName(@PathVariable String serverName) {
        serverService.deleteServerByName(serverName);
        return ResponseEntity.noContent().build();
    }

    // Kullanıcıları görüntüleme
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Kullanıcıları isme göre görüntüleme
    @GetMapping("/users/{username}")
    public ResponseEntity<User> findByUsername(@PathVariable String username) {
        User user = userRepository.findByUsername(username);
        return ResponseEntity.ok(user);
    }
}
