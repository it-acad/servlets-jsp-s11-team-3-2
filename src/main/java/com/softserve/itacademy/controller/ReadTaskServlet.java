package com.softserve.itacademy.controller;

import com.softserve.itacademy.model.Task;
import com.softserve.itacademy.repository.TaskRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/read-task")
public class ReadTaskServlet extends HttpServlet {

    private TaskRepository repo;

    @Override
    public void init() {
        repo = TaskRepository.getTaskRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Task task = repo.read(Integer.parseInt(req.getParameter("id")));
        if (task != null) {
            req.setAttribute("task", task);
            req.getRequestDispatcher("/WEB-INF/read-task.jsp").forward(req, resp);
        } else {
            resp.setStatus(404);
            req.setAttribute("url",req.getHttpServletMapping().getPattern());
            req.getRequestDispatcher("/WEB-INF/task-not-found.jsp").forward(req, resp);
        }
    }
}
