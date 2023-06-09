package es.logixs.web.controllers;

import es.logixs.web.domain.Request;
import es.logixs.web.dto.RequestDTO;
import es.logixs.web.dto.UserDTO;
import es.logixs.web.services.SaleProductRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("webapi/request")
public class RequestController {
    
    @Autowired
    private SaleProductRequestService saleProductRequestService;

    @GetMapping
    public List<RequestDTO> findAllRequests() {
        List<RequestDTO> listRequestDto = new ArrayList<>();

        for (Request request : saleProductRequestService.findAllRequests()) {
            listRequestDto.add(new RequestDTO(request));
        }
        return listRequestDto;
    }

    @GetMapping("/{objectId}")
    public RequestDTO findOneRequest(@PathVariable String objectId) {
        return new RequestDTO(saleProductRequestService.findOneRequest(UUID.fromString(objectId)));
    }

    @DeleteMapping("/{objectId}")
    public void deleteRequest(@PathVariable String objectId) {
        saleProductRequestService.deleteRequest(new Request(UUID.fromString(objectId)));
    }
    @PostMapping
    public RequestDTO insertRequest(@RequestBody RequestDTO requestDTO) {
        return new RequestDTO(saleProductRequestService.insertRequest(requestDTO.createRequest()));
    }
    @PutMapping("/{objectId}")
    public void updateRequest(@RequestBody RequestDTO requestDTO, @PathVariable String objectId) {
        saleProductRequestService.updateRequest(requestDTO.createRequest(), UUID.fromString(objectId));
    }

  
   

}
