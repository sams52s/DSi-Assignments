package com.sams.hostelmsapp.hostelmsapp.controller;

import com.sams.hostelmsapp.hostelmsapp.user.Border;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/borders")
public class ManagementController {
    private static final List<Border> BORDERS = Arrays.asList(
            new Border(1,"Sams"),
            new Border(2,"Aly"),
            new Border(3,"Toufiq")
    );

    //CRUD operation are doing here.
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPERVISOR')")
    public List<Border> getAllBorders(){
        System.out.println("getAllBorders"); //for checking from console it is running ok or not
        return BORDERS;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('border:write')")
    public void registerNewBorder(@RequestBody Border border){
        System.out.println("registerNewBorder"); //for checking from console it is running ok or not
        System.out.println(border);
    }
    @DeleteMapping(path = "{borderId}")
    @PreAuthorize("hasAuthority('border:write')")
    public void deleteBorder(@PathVariable("borderId") Integer borderId){
        System.out.println("deleteBorder"); //for checking from console it is running ok or not
        System.out.println(borderId);
    }

    @PutMapping(path = "{borderId}")
    @PreAuthorize("hasAuthority('border:write')")
    public void updateBorder(@PathVariable("borderId") Integer borderId,@RequestBody Border border){
        System.out.println("updateBorder"); //for checking from console it is running ok or not
        System.out.println(String.format("%s %s",borderId,border));
    }



}
