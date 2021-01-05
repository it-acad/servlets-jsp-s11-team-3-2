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

@WebServlet("/create-task")
public class CreateTaskServlet extends HttpServlet {

    private TaskRepository taskRepository;

    @Override
    public void init() throws ServletException {
        super.init();
        taskRepository = TaskRepository.getTaskRepository();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/create-task.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name").trim();
        if (name.equals("")) {
            request.setAttribute("result", "Name is empty!");
            request.getRequestDispatcher("/WEB-INF/create-task.jsp").forward(request, response);
            return;
        }

        String priorityStr = request.getParameter("priority").trim().toUpperCase();
        Priority priority = Priority.valueOf(priorityStr);

        boolean taskContains = taskRepository
                .all()
                .stream()
                .anyMatch(task -> task.getTitle().toLowerCase().equals(name.toLowerCase()));

        if (taskContains) {
            request.setAttribute("result", "Task with a given name already exists!");
        } else {
            Task task = new Task(name, priority);
            taskRepository.create(task);
            request.setAttribute("result", "Added to task list");
        }

        request.getRequestDispatcher("/WEB-INF/create-task.jsp").forward(request, response);
    }
}
