package at.aistleitner.ahoiburger.config

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.security.SecurityScheme
import org.springframework.context.annotation.Configuration

@Configuration
@OpenAPIDefinition(
    info = Info(title = "Ahoi-Burger API", version = "1.0", description = "API documentation for Ahoi-Burger"),
    security = [SecurityRequirement(name = "ApiKeyAuth")]
)
@SecurityScheme(
    name = "ApiKeyAuth",
    type = SecuritySchemeType.APIKEY,
    `in` = SecuritySchemeIn.HEADER,
    paramName = "X-Api-Key"
)
class SwaggerConfig
