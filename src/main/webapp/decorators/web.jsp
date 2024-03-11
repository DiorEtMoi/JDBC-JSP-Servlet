<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Small Business - Start Bootstrap Template</title>
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="<c:url value="/template/web/css/styles.css" />" rel="stylesheet" />
    </head>
    <body>
        <!-- Responsive navbar-->
        <%@include file="/common/web/header.jsp" %>
        <!-- Page Content-->
       <dec:body></dec:body>
        <!-- Footer-->
         <%@include file="/common/web/footer.jsp" %>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="<c:url value="/template/web/js/scripts.js" />"></script>
    </body>
</html>
