package com.venta.controllers;

import com.venta.definitions.Methods;
import com.venta.definitions.Paths;
import com.venta.model.entities.UserEntity;
import com.venta.model.filtration.UserFilter;
import com.venta.model.requests.ByIDRequest;
import com.venta.model.requests.users.UserCreateRequest;
import com.venta.operations.users.UserCountOperation;
import com.venta.operations.users.UserCreateOperation;
import com.venta.operations.users.UserGetOperation;
import com.venta.operations.users.UserSearchOperation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import java.util.List;

@Api(tags = "Users")
@RestController
@AllArgsConstructor
@RequestMapping(Paths.USERS)
public final class UserController {
    private final UserCreateOperation userCreateOperation;
    private final UserCountOperation userCountOperation;
    private final UserGetOperation userGetOperation;
    private final UserSearchOperation userSearchOperation;

    @PermitAll
    @PostMapping(Methods.CREATE)
    @ApiOperation("Create new user with credentials")
    public final Long create(@RequestBody @Valid final UserCreateRequest request) {
        return userCreateOperation.perform(request);
    }

    @PostMapping(Methods.GET)
    @ApiOperation("Get a user by id")
    public final UserEntity get(@RequestBody @Valid final ByIDRequest request) {
        return userGetOperation.perform(request);
    }

    @PostMapping(Methods.COUNT)
    @ApiOperation("Count users")
    public final Integer count(@RequestBody @Valid final UserFilter filter) {
        return userCountOperation.perform(filter);
    }

    @PostMapping(Methods.SEARCH)
    @ApiOperation("Search users")
    public final List<UserEntity> search(@RequestBody @Valid final UserFilter filter) {
        return userSearchOperation.perform(filter);
    }
}