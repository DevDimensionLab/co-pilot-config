workspace {

    model {
        plyResources = softwareSystem "Ply Resources" {
            description "Code templates and examples designed to target various facets of an application's architecture"

            server = container "Server" "Desc" "Code examples" {
                common_dockerfile = component "dockerfile" "" "Template" "Template"
                common_flyway = component "flyway" "" "Template" "Template"
                scheduling_basic-task = component "basic-task" "" "Template" "Template"
            }

            templates = container "Templates" "Desc" "Code examples" {
                template_rest_api = component "rest-api" "" "Template" "Template"
                template_rest_basic-controller = component "basic-controller" "" "Template" "Template"
                template_common_maven-docker-standalone = component "maven-docker-standalone" "" "Template" "Template"
                template_logstash_logback = component "logstash_logback" "" "Template" "Template"

            }

            examples = container "Examples" "Examples" "Examples" {
                example_jib_ply = component "JIB" "" "Ply" "Ply"
                example_restApi_ply = component "REST API" "" "Ply" "Ply"
                example_restService_ply = component "REST SERVICE" "" "Ply" "Ply"
            }

        }

        example_jib_ply -> template_logstash_logback
        example_jib_ply -> template_common_maven-docker-standalone

        example_restApi_ply -> template_rest_api

        example_restService_ply -> template_logstash_logback
        example_restService_ply -> template_rest_basic-controller


    }

    views {


        container plyResources "Templates" {
            include *
            autolayout
        }


        component server "server" {
            include *
            autolayout
        }

        component examples "JIB" {
            include example_jib_ply
            include template_logstash_logback
            include template_common_maven-docker-standalone

            autolayout
        }


        component examples "REST-API" {
            include example_restApi_ply
            include template_rest_api
            autolayout
        }

        component examples "REST-SERVICE" {
            include example_restService_ply
            include template_logstash_logback
            include template_rest_basic-controller
            autolayout
        }



        themes https://static.structurizr.com/themes/default/theme.json
    }
}