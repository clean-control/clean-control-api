package com.example.cleancontrol.api.service;



import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.cleancontrol.api.dto.fileDto.FileResponse;
import com.example.cleancontrol.domain.model.Category;
import com.example.cleancontrol.domain.model.Client;
import com.example.cleancontrol.domain.model.Content;
import com.example.cleancontrol.domain.model.Employee;
import com.example.cleancontrol.domain.model.Enterprise;
import com.example.cleancontrol.domain.model.Product;
import com.example.cleancontrol.domain.model.ProductType;
import com.example.cleancontrol.domain.model.ServiceType;
import com.example.cleancontrol.domain.model.Services;
import com.example.cleancontrol.domain.repository.ClientRepository;
import com.example.cleancontrol.domain.repository.ContentRepository;
import com.example.cleancontrol.domain.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContentService {

    private final ContentRepository contentRepository;
    private final ClientService clientService;
    private final EmployeeService employeeService;
    private final EnterpriseService enterpriseService;
    private final CategoryService categoryService;
    private final ProductService productService;
    private final ServicesService serviceService;
    private final ProductTypeService productTypeService;
    private final ServiceTypeService serviceTypeService;

    private final FileService fileService;

    public FileResponse uploadFile(MultipartFile file, Integer id, String type) {
        try {
            if (file == null) {
                throw new Exception("Arquivo não pode ser nulo");
            }


            Object obj  = buscarReferenciaPorId(id, type);

            if (obj == null) {
                throw new Exception("Referencia não encontradas››");
            }
            String fileDownloadUri = fileService.upload(file);

            Content fileResponse = Content.builder()
                    .name(file.getOriginalFilename())
                    .path(fileDownloadUri)
                    .fileExtension(file.getContentType())
                    .fileSize((double) file.getSize())
                    .client(obj instanceof Client ? (Client) obj : null)
                    .employee(obj instanceof Employee ? (Employee) obj : null)
                    .enterprise(obj instanceof Enterprise ? (Enterprise) obj : null)
                    .category(obj instanceof Category ? (Category) obj : null)
                    .product(obj instanceof Product ? (Product) obj : null)
                    .service(obj instanceof Services ? (Services) obj : null)
                    .productType(obj instanceof ProductType ? (ProductType) obj : null)
                    .serviceType(obj instanceof ServiceType ? (ServiceType) obj : null)
                    .build();

            Content content = contentRepository.save(fileResponse);
            

            return new FileResponse(
                    content.getId(),
                    content.getName(),
                    content.getDescription(),
                    content.getFileExtension(),
                    content.getPath(),
                    content.getFileSize(),
                    content.getClient(),
                    content.getEmployee(),
                    content.getEnterprise(),
                    content.getCategory(),
                    content.getProduct(),
                    content.getService(),
                    content.getProductType(),
                    content.getServiceType(),
                    content.getCreateDate(),
                    content.getUpdateDate()
            );
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível fazer o upload do arquivo", e);
        }
    }



    private Object buscarReferenciaPorId(Integer id, String type) {
        type = type.toLowerCase();
        switch (type) {
            case "client":
                return clientService.findById(id);
            case "employee":
                return employeeService.findById(id);
            case "enterprise":
                return enterpriseService.findById(id);
            case "category":
                return categoryService.findById(id);
            case "product":
                return productService.findById(id);
            case "service":
                return serviceService.findById(id);
            case "producttype":
                return productTypeService.findById(id);
            case "servicetype":
                return serviceTypeService.findById(id);
            default:
                return null;
        }
    }


    public List<Content> findAll( ) {
        return contentRepository.findAll();
    }
}
