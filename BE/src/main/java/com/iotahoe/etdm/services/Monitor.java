package com.iotahoe.etdm.services;

import com.iotahoe.etdm.entities.CDatabase;

import java.util.List;

public interface Monitor {

    void start(CDatabase database);
    void stop(CDatabase database);
    List<CDatabase> current();

}
