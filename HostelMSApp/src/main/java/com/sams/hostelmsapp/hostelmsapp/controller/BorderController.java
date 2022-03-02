package com.sams.hostelmsapp.hostelmsapp.controller;

import com.sams.hostelmsapp.hostelmsapp.user.Border;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/borders")
public class BorderController {

    private static final List<Border> BORDERS = Arrays.asList(
            new Border(1,"Sams"),
            new Border(2,"Aly"),
            new Border(3,"Toufiq")
    );

    @GetMapping(path = "{borderId}")
    public Border getBorder(@PathVariable("borderId") Integer borderId){
        return BORDERS.stream()
                .filter(border -> borderId.equals(border.getBorderId()))
                .findFirst()
                .orElseThrow(()-> new IllegalStateException("Border "+ borderId + "does not exists"));
    }
}

