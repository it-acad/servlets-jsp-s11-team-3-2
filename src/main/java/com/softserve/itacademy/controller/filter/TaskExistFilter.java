package com.softserve.itacademy.controller.filter;

import com.softserve.itacademy.repository.TaskRepository;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter({"/read-task","/edit-task","/delete-task"})
public class TaskExistFilter implements Filter {
    private TaskRepository repo;

    @Override
    public void init(FilterConfig filterConfig) {
        repo = TaskRepository.getTaskRepository();
    }


    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        if (repo.read(Integer.parseInt(req.getParameter("id"))) == null) {
            HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
            HttpServletRequest httpServletRequest = (HttpServletRequest) req;
            httpServletResponse.setStatus(404);
            httpServletRequest.setAttribute("url", httpServletRequest.getHttpServletMapping().getPattern());
            httpServletRequest.getRequestDispatcher("/WEB-INF/task-not-found.jsp").forward(req, resp);
        } else {
            filterChain.doFilter(req, resp);
        }

    }
}
