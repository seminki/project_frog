google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart1);
      
      $(window).resize(()=>{
        google.charts.setOnLoadCallback(drawChart1);
      })
      function drawChart1() {
        var data = google.visualization.arrayToDataTable([
          ['Year', 'Sales', 'Expenses'],
          ['2004',  1000,      400],
          ['2005',  1170,      460],
          ['2006',  660,       1120],
          ['2007',  1030,      540]
        ]);

        var options = {
          title: 'Company Performance',
          curveType: 'function',
          legend: { position: 'bottom' },
        };

        var chart = new google.visualization.LineChart(document.getElementsByClassName("sales-stat-container")[0]);

        chart.draw(data, options);
      }