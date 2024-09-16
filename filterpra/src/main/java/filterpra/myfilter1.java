package filterpra;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.PrintWriter;

public class myfilter1 extends HttpFilter implements Filter {
    public myfilter1() {
        super();
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        System.out.println("you are present inside the filter");
        HttpServletRequest req = (HttpServletRequest) request;
        int num = Integer.parseInt(request.getParameter("num"));

        if (num >= 1) {
            boolean isPrime = true;
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.println("Inserted number is a prime number");
                chain.doFilter(request, response);
            } else {
                out.print("The number that you have entered is not a prime number");
            }
        } else {
            out.print("Invalid input.....(please provide a positive number greater than 0)");
        }
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }
}

/*

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.PrintWriter;

public class myfilter1 extends HttpFilter implements Filter {
    public myfilter1() {
        super();
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        System.out.println("In filter");
        HttpServletRequest req = (HttpServletRequest) request;
        int num = Integer.parseInt(request.getParameter("num"));

        if (num >= 1) {
            boolean isPrime = true;
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.println("Inserted number is prime");
                chain.doFilter(request, response);
            } else {
                out.print("Not a prime number");
            }
        } else {
            out.print("Invalid input");
        }
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }
}*/
