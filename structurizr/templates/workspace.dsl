workspace {

    model {
        templatesResources = softwareSystem "Template Resources" {

            templates = container "Templates" "Desc" "Code examples" {
                templateParent = component "Template parent" "" "Template parent" "Template"
                common = component "common" "" "Template" "Template"
                rest_api = component "rest_api" "" "Template" "Template"
                server = component "server" "" "Template" "Template"
            }
        }

        common -> templateParent "inherits"  {
            tags "Module"
        }
        rest_api -> templateParent "inherits" {
            tags "Module"
        }
        server -> templateParent "inherits" {
            tags "Module"
        }
    }

    views {

        component templates "template" {
            include *
            autolayout
        }

        styles {
            relationship "Module" {
                color #000000
                dashed false
                thickness 6
            }
        }

        themes https://static.structurizr.com/themes/default/theme.json
    }
}