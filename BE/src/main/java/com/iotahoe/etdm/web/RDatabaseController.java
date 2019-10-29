package com.iotahoe.etdm.web;

import java.util.Map;

import javax.annotation.Resource;

import com.iotahoe.etdm.entities.CDatabase;
import com.iotahoe.etdm.services.CDatabaseService;
import com.iotahoe.etdm.services.RDatabaseTypeService;
import com.iotahoe.etdm.services.reqresp.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
//import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/databases")
public class RDatabaseController {
    // private static Logger log =
    // org.slf4j.LoggerFactory.getLogger(RDatabaseController.class);

    @Resource
    RDatabaseTypeService databaseTypeService;

    @Resource
    CDatabaseService databaseService;

    @RequestMapping(value = "types", method = RequestMethod.GET)

    public ResponseEntity<?> allDatabaseTypes() {
        return ResponseEntity.ok(databaseTypeService.getAll());
    }

    @RequestMapping(value = "all")
    @ResponseStatus(HttpStatus.OK)
    public Page<CDatabaseResp> getsAll(@PageableDefault Pageable pageable,
            @RequestBody(required = false) Map<String, String> filters) {
        return databaseService.all(pageable, filters);
    }

    @RequestMapping(value = "check", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> checkConnection(@RequestBody(required = true) CDatabaseReq req) {
        return ResponseEntity.ok(databaseService.checkConnection(req));
    }

}
