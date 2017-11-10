<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
 <head>	
  <meta charset="UTF-8">
  <meta name="Generator" content="txt">
  <meta name="Author" content="QQ:284190056">
  <meta name="Keywords" content="二维码;网页;生成">
  <meta name="Description" content="二维码开发网页版;爱的二维码">
  <title>制作爱的二维码</title>
  <style>
  *{margin:0}
  body{background:url("images/1.jpg");background-size: cover}

  /*start qrcode*/
  h1{
        font-size:30px;
        text-align:center;
		color:#9e3eff;
		background:-webkit-linear-gradient(45deg,#9900ff,#00ecec,#33ffff,#00ff99,#00ccff);
		color:transparent;
		-webkit-background-clip:text;
		animation:randombackground 22s linear infinite;
		background-size:193px 39px;
		}
  /**网页样式**/
  .qrcode{width:400px;margin:200px auto;
                text-align:center;line-height:80px;}
   /*按钮样式*/
  .qrcode .sub{
   width:300px;
   height:30px;
   border:none;
   outline:none;
   background: rgb(49, 230, 213);
   box-shadow: 1px 2px 5px #000;
   border-radius: 6px;


   /*放射按钮样式*/
   /*-webkit-animation-name:greenPulse;*/
  /*-webkit-animation-duration:2s ;*/
  /*-webkit-animation-iteration-count:infinite ;*/
  /*border-radius:5px;*/
}
  .qrcode .sub:active{box-shadow:0px  0px  5px  #000}

  .qrcode .text{width:340px;height:190px}
  @keyframes randombackground{
        from{background-position:0 0;}
		to{background-position:10000px 0;}

	}
  /*放射按钮动画,使用后会覆盖按钮按下效果*/
/*@-webkit-keyframes  greenPulse {*/
   /*from{ background-color:rgba(2, 167, 167, 1) ; -webkit-box-shadow:0  0  9px  #333 ; }*/
   /*50%{ background-color:#33ffff; -webkit-box-shadow:0  0  5px  #00ccff ; }*/
   /*to{ background-color:rgba(2, 167, 167, 1);-webkit-box-shadow:0  0  9px  #333 ; }*/
/*}*/

   /* end code */
  </style>

 </head>
 <body>
   <!-- start qrcode -->
  <div class="qrcode">
    <h1>Java网页在线生成二维码</h1>
	<textarea class="text" ></textarea>
	<input type="submit" value="点击生成二维码" class="sub"></input>
	
  </div>


 </body>
</html>
