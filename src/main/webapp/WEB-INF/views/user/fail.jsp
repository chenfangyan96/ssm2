<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/1
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        function shence_set_Issue_Prod_Insurance() {
            var total_baofei = isEmpty($("#sumPremium").val()) ? 0:parseInt($("#sumPremium").val());
            var baoe_zhuxian = isEmpty($("#riskDetailamount0").val()) ? 0:parseInt($("#riskDetailamount0").val());
            var baofei_zhuxian = isEmpty($("#riskDetailpremium0").val()) ? 0:parseInt($("#riskDetailpremium0").val());
            var is_fujia=$('#fujiaDiv em.checkYes').each(function(i,val){var hello=$(this).parent().text();return hello})};
        var jiaofei_way = function jiaofei(){
            if($("#riskDetailpayWay0").val()=='Y'){return"年交"}
        };
        var fujia_flag =isEmpty(!$('#fujiaDiv em.checkYes').parent().text());
        sensors.track("Issue_Prod_Insurance",{
            product_name: $("#riskName").val(),//保险产品名称
            insurance_premium: baoe_zhuxian,//基本保额 数值
            insurance_duration: $("#riskDetailperiod0").val(),//保险期间
            payment_year: $("#riskDetailpayment0").val(),//交费年期
            regular_premium:baofei_zhuxian ,//期交保费 数值
            additional_insurances:fujia_flag,//是否选择附加险 BOOL
            additional_product_name:is_fujia,//其他附加险名称
            payment_mode:jiaofei_way,//交费方式
            totals_premium:total_baofei //合计保费 数值
        });
        }
    </script>
</head>
<body>



sorry
fail  in   login:${msg}
</body>
</html>
