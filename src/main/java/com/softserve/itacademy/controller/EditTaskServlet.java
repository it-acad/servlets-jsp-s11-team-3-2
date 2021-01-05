package com.softserve.itacademy.controller;

import com.softserve.itacademy.model.Priority;
import com.softserve.itacademy.model.Task;
import com.softserve.itacademy.repository.TaskRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit-task")
public class EditTaskServlet extends HttpServlet {
    private TaskRepository repo;
    private Task task;

    @Override
    public void init() {
        repo = TaskRepository.getTaskRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        task = repo.read(Integer.parseInt(req.getParameter("id")));
        if (task != null) {
            req.setAttribute("task", task);
            req.getRequestDispatcher("/WEB-INF/edit-task.jsp").forward(req, resp);
        } else {
            resp.setStatus(404);
            req.setAttribute("url", req.getHttpServletMapping().getPattern());
            req.getRequestDispatcher("/WEB-INF/task-not-found.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");

        if (name.isEmpty()) {
            req.setAttribute("emptyName", "Name is empty!");
            req.setAttribute("task", task);
            req.getRequestDispatcher("/WEB-INF/edit-task.jsp").forward(req, resp);
            return;
        }
        task.setTitle(name);
        task.setPriority(Priority.valueOf(req.getParameter("priority")));
        if (repo.update(task)) {
            resp.sendRedirect("/tasks-list");
        } else {
            resp.setStatus(404);
            req.setAttribute("url", req.getHttpServletMapping().getPattern());
            req.getRequestDispatcher("/WEB-INF/task-not-found.jsp").forward(req, resp);
        }
    }
}
