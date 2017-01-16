package fr.lteconsulting;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class SecurityFilter implements Filter {

	private List<String> urlsAutorisees;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		String contextPath = filterConfig.getServletContext().getContextPath();

		urlsAutorisees = Arrays.asList(contextPath + "/entete.css",
				contextPath + "/login", contextPath + "/index.html",
				contextPath + "/creationCompte.html",
				contextPath + "/creerCompte");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		if (request instanceof HttpServletRequest) {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			Joueur joueurConnecte = DonneesScope.getJoueurSession(httpRequest);

			if (joueurConnecte == null) {
				String uri = httpRequest.getRequestURI();
				if (!urlsAutorisees.contains(uri)) {
					HttpServletResponse httpResponse = (HttpServletResponse) response;

					httpResponse.sendRedirect("index.html");
					return;
				} 
			}
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {

	}
}
