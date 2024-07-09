package com.example.cleancontrol.api.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.cleancontrol.api.dto.fileDto.FileResponse;
import com.example.cleancontrol.config.FileStorageApiProperties;
import com.example.cleancontrol.domain.model.Client;
import com.example.cleancontrol.domain.model.Content;
import com.example.cleancontrol.domain.model.Employee;
import com.example.cleancontrol.domain.repository.ClientRepository;
import com.example.cleancontrol.domain.repository.ContentRepository;
import com.example.cleancontrol.domain.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContentService {

    private final ContentRepository contentRepository;
    private final ClientRepository clientRepository;
    private final EmployeeRepository employeeRepository;

    private final FileService fileService;

    public FileResponse uploadFile(MultipartFile file, Integer userId, String type) {
        try {
            if (file == null) {
                throw new RuntimeException("Arquivo não pode ser nulo");
            }

            

            String fileDownloadUri = fileService.upload(file);

            Object user = null;
            if (type.equals("Client")) {
                user = clientRepository.findById(userId)
                        .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
            } else if (type.equals("Employee")) {
                user = employeeRepository.findById(userId)
                        .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
            } else {
                throw new RuntimeException("Tipo de usuário inválido");
            }

            Content fileResponse = Content.builder()
                    .name(file.getOriginalFilename())
                    .path(fileDownloadUri)
                    .fileExtension(file.getContentType())
                    .fileSize((double) file.getSize())
                    .client(type.equals("Client") ? (Client) user : null)
                    .employee(type.equals("Employee") ? (Employee) user : null)
                    .build();

            Content content = contentRepository.save(fileResponse);

            return new FileResponse(content.getId(), content.getName(), content.getDescription(),
                    content.getFileExtension(), content.getPath(), content.getFileSize(), content.getClient(),
                    content.getEmployee(), content.getCreateDate(), content.getUpdateDate());
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível fazer o upload do arquivo", e);
        }
    }

}
