package es.logixs.web.controllers;

import es.logixs.web.domain.Sale;
import es.logixs.web.dto.SaleDTO;
import es.logixs.web.services.SaleProductRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("webapi/sale")
public class SaleController {

    @Autowired
    private SaleProductRequestService saleProductRequestService;

    @GetMapping
    public List<SaleDTO> findAllSales() {
        List<SaleDTO> saleDTOList = new ArrayList<>();
        for (Sale sale : saleProductRequestService.findAllSales()) {
            saleDTOList.add(new SaleDTO(sale));
        }
        return saleDTOList;
    }

    @GetMapping("/{objectId}")
    public SaleDTO findOneSale(@PathVariable String objectId) {
        return new SaleDTO(saleProductRequestService.findOneSale(objectId));
    }

    @DeleteMapping("/{objectId}")
    public void deleteSale(@PathVariable String objectId) {
        saleProductRequestService.deleteSale(objectId);
    }

    @PostMapping
    public Sale insertSale(@RequestBody SaleDTO saleDto) {
        return saleProductRequestService.insertSale(saleDto.createSale());
    }

    @PutMapping("/{objectId}")
    public void updateSale(@RequestBody SaleDTO saleDto, @PathVariable String objectId) {
        saleProductRequestService.updateSale(saleDto.createSale(), objectId);
    }
}
