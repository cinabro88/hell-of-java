package com.hell.board.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mingook on 2016년8월 2일 (화).
 */
public abstract class Command {
    protected HttpServletRequest request;
    protected HttpServletResponse response;

    public Command(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public abstract void execute() throws IOException, ServletException;
}
