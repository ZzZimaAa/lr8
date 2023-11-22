<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="javax.servlet.jsp.jstl.core.*" %>
<%@ page import="com.google.gson.Gson" %>
<html>
<head>
    <title>Product List</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <style>
        #chartContainer {
            margin-top: 20px; /* Adjust the top margin as needed */
        }
    </style>
</head>
<body>
    <h1>Product List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Name</th>
                <th>Price</th>
                <th>Category</th>
                <th>Quantity</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.category}</td>
                    <td>${product.quantity}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <!-- Place the chart in a separate container -->
    <div id="chartContainer">
        <canvas id="priceChart" width="600" height="400"></canvas>
    </div>

    <script>
        var ctx = document.getElementById('priceChart').getContext('2d');

        // Convert products to JSON string using Gson
        var products = <%= new Gson().toJson(request.getAttribute("products")) %>;

        // Extract prices and names for chart data
        var quantities = products.map(function(product) {
            return product.quantity;
        });

        var names = products.map(function(product) {
            return product.name;
        });

        // Create pie chart with custom options
        var priceChart = new Chart(ctx, {
            type: 'pie',
            data: {
                labels: names,
                datasets: [{
                    data: quantities,
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.6)',
                        'rgba(54, 162, 235, 0.6)',
                        'rgba(255, 206, 86, 0.6)',
                        'rgba(75, 192, 192, 0.6)',
                        'rgba(153, 102, 255, 0.6)',
                        'rgba(255, 159, 64, 0.6)'
                    ]
                }]
            },
            options: {
                responsive: true, // Make the chart responsive to container size
                maintainAspectRatio: false, // Do not maintain the aspect ratio
                legend: {
                    position: 'right' // Adjust the legend position
                }
            }
        });
    </script>
</body>
</html>
