package com.example.cities.debug;

import com.example.cities.controller.CitiesController;
import com.example.cities.dto.CityRouteDto;
import com.example.cities.dto.CitySearchDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Collection;
import java.util.stream.Collectors;

import static com.example.cities.constant.ApplicationConstants.URL_ADD_ROUTE;
import static com.example.cities.constant.ApplicationConstants.URL_SEARCH;
import static com.example.cities.debug.DebugConstants.ATTR_FROM;
import static com.example.cities.debug.DebugConstants.ATTR_PATHS;
import static com.example.cities.debug.DebugConstants.ATTR_ROUTE;
import static com.example.cities.debug.DebugConstants.ATTR_TO;
import static com.example.cities.debug.DebugConstants.URL_REDIRECT_HOME;
import static com.example.cities.debug.DebugConstants.VIEW_MAIN;


@Controller
@AllArgsConstructor
@RequestMapping
public class CitiesTestController {

    private final CitiesController controller;

    
    @GetMapping
    public String form(final Model model) {
        model.addAttribute(ATTR_ROUTE, new CityRouteDto());
        return VIEW_MAIN;
    }

    
    @PostMapping(URL_ADD_ROUTE)
    public String addRoute(@Valid final CityRouteDto route, final BindingResult result) {

        if (!result.hasErrors()) {
            controller.addRoute(route, result);
        }

        return URL_REDIRECT_HOME;
    }

    
    @GetMapping(URL_SEARCH)
    public String search(@Valid final CitySearchDto dto, final Model model) {

        final Collection<SpecialResultDto> paths = controller.search(dto).stream()
                .map(SpecialResultDto::new).collect(Collectors.toList());
        model.addAttribute(ATTR_PATHS, paths);
        model.addAttribute(ATTR_FROM, dto.getFrom());
        model.addAttribute(ATTR_TO, dto.getTo());
        return form(model);
    }
}