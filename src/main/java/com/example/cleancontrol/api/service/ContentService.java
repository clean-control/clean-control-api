package com.example.cleancontrol.api.service;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.cleancontrol.api.dto.fileDto.FileResponse;
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
                throw new Exception("Arquivo não pode ser nulo");
            }


            Object user  = buscarUsuarioPorTipo(userId, type);

            if (user == null) {
                throw new Exception("Usuário não encontrado");
            }
            String fileDownloadUri = fileService.upload(file);


            Content fileResponse = Content.builder()
                    .name(file.getOriginalFilename())
                    .path(fileDownloadUri)
                    .fileExtension(file.getContentType())
                    .fileSize((double) file.getSize())
                    .client(user instanceof Client ? (Client) user : null)
                    .employee(user instanceof Employee ? (Employee) user : null)
                    .build();

            Content content = contentRepository.save(fileResponse);

            return new FileResponse(content.getId(), content.getName(), content.getDescription(),
                    content.getFileExtension(), content.getPath(), content.getFileSize(), content.getClient(),
                    content.getEmployee(), content.getCreateDate(), content.getUpdateDate());
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível fazer o upload do arquivo", e);
        }
    }



    private Object buscarUsuarioPorTipo(Integer userId, String type) {
        type = type.toLowerCase();
        if (type.equals("client")) {
            return clientRepository.findById(userId).orElse(null);
        } else if (type.equals("employee")) {
            return employeeRepository.findById(userId).orElse(null);
        } else {
            return null;
        }
    }
}
