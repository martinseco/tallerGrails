<!doctype html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Taller Grails</title>
    </head>
    <body>
        <div class="container-fluid">

            <g:form class="form-group" action="search" method="POST">
                <g:if test="${flash.error}">
                    <div class="alert alert-danger" >${flash.error}</div>
                </g:if>
                <g:if test="${flash.success}">
                    <div class="alert alert-success">${flash.success}</div>
                </g:if>

                <h1>Buscar Agencias</h1>
                <div class="col-md-4">
                    <div>
                        <fieldset class="form">
                            <label for="paymentMethod"> Metodos de Pago </label>
                            <g:select id="paymentMethod"
                                      name="paymentMethod"
                                      from="${lista}"
                                      optionKey="${{it.id}}"
                                      optionValue="${{it.name}}"
                                      style="float: right"/>
                        </fieldset>
                    </div>
                    <div>
                        <fieldset class="form">
                            <label for="direccion">Dirección</label>
                            <g:textField name="direccion" required="true" style="float: right" placeholder="Dirección"></g:textField>
                        </fieldset>
                    </div>

                    <div>
                        <fieldset class="form">
                            <label for="radio">Radio</label>
                            <g:textField name="radio" required="true" style="float: right" placeholder="Radio"></g:textField>
                        </fieldset>
                    </div>
                    <div>
                        <fieldset class="buttons">
                            <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Buscar')}" />
                        </fieldset>
                    </div>
                </div>


            </g:form>

        </div>


    </body>
</html>
