package com.iotahoe.etdm.web;

import com.iotahoe.etdm.services.RDatabaseTypeService;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/database")
public class RDatabaseController {
    private static Logger log = org.slf4j.LoggerFactory.getLogger(RDatabaseController.class);

    @Resource
    RDatabaseTypeService databaseTypeService;

    @RequestMapping(value = "/types", method = RequestMethod.GET)
    public ResponseEntity<?> allDatabaseTypes() {
        return ResponseEntity.ok(databaseTypeService.getAll());
    }
}
