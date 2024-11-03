package at.aistleitner.ahoiburger.core.authentication

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class ApiKeyFilter(
    @Value("\${application.api-key}") private val validApiKey: String
) : OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        val path = request.requestURI

        if (path.startsWith("/swagger-ui") || path.startsWith("/api-docs")) {
            filterChain.doFilter(request, response)
            return
        }

        val requestApiKey = request.getHeader("X-Api-key")
        if (requestApiKey != validApiKey) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Invalid or missing API Key")
            return
        }

        filterChain.doFilter(request, response)
    }
}
