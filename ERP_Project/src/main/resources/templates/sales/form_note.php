<?//php if (!is_array($prtCompany)) die(); ?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>거래명세서</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
.border_out {font-family: 굴림;border: 3px double black;}
body, table, tr, td {font-family:굴림, verdana, arial; font-size: 10px;color: #000000; border:0px;}
.border_in {border-width:1px; border-color:black; border-style:solid none solid solid;}
.l_dot {border-style:dotted; border-width:0 0 0 1px; border-color:#4C4C4C;}
.lb_dot {border-style:dotted; border-width:0 0 1px 1px; border-color:#6C6C6C;}
.tl_dot {border-style:solid solid solid dotted; border-width:1px 0px 1px 1px; border-color:black black black #6C6C6C;}
#command_bar {
  font-size: 10pt;
  background-color: #FEFFD2;
  border: 1px solid #AF9E29;
  padding: 5px;
  margin-bottom: 10px;
}
.sign_area {
  position: relative;
}
.sign_img {
  position: absolute;
  top: 15px;
  left: 190px;
}
</style>
<script type="text/javascript">

window.resizeTo(500,690);
window.focus();

function printNow() {
  document.getElementById('command_bar').style.display = 'none';
  window.print();
}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<div id="command_bar">
  A4용지를 준비하고 인쇄방향을 가로로 설정하세요. &nbsp; <input type="button" value="인쇄하기" onclick="printNow()" /> <input type="button" value="뒤로" onclick="window.history.go(-1)" />
</div>
<table width="460" border="0" cellspacing="0" cellpadding="0" align="<?=$prtAlign?>" style="table-layout:auto">
  <tr>
<?php for ($copy_=1; $copy_<=2; $copy_++) { ?>
    <td>
      <table width="460" cellpadding="0" cellspacing="0" class="border_out">
        <tr height="44"> 
          <td><table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td align="center"><span style="font-size:18pt;font-weight:bold;">거 래 명 세 서</span></td>
                <td><table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td class="border_in" align="center" style="border-top-style:none">작성일</td>
                      <td class="border_in" align="center" style="border-top-style:none">페이지</td>
                      <td class="border_in" align="center" style="border-top-style:none">일련번호</td>
                    </tr>
                    <tr>
                      <td class="border_in" align="center" style="border-top-style:none;border-bottom-style:none;"><?=$prtInfo['date']?></td>
                      <td align="center" class="border_in" style="border-top-style:none;border-bottom-style:none;"><?=$prtInfo['page']?></td>
                      <td align="center" class="border_in" style="border-top-style:none;border-bottom-style:none;"><?=$prtInfo['serial']?></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
        </tr>
        <tr> 
          <td><table width="100%" class="border_in" style="border-left-style:none" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="45%"><table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr> 
                      <td width="18" align="center" class="border_in" style="border-left-style:none"><span style="line-height:20px">공<br />
                        급<br />
                        받<br />
                        는<br />
                        자</span></td>
                      <td><table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
                          <tr height="30"> 
                            <td width="25%" align="center" class="border_in">상 호<br />(법인명)</td>
                            <td width="75%" class="border_in">
                              <table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                  <td align="center"><strong style="font-size:11px"><?=$prtCustomer['company']?></strong></td>
                                  <td width="25%" align="center" class="l_dot" style="font-size:12px;">귀하</td>
                                </tr>
                              </table>
                            </td>
                          </tr>
                          <tr height="30"> 
                            <td align="center" class="border_in" style="border-top-style:none">사업장<br />
                              주 소</td>
                            <td class="border_in" style="border-top-style:none" align="center"><?=$prtCustomer['address']?></td>
                          </tr>
                          <tr height="30"> 
                            <td align="center" class="border_in" style="border-top-style:none">전화번호</td>
                            <td class="border_in" style="border-top-style:none" align="center"><?=$prtCustomer['tel']?></td>
                          </tr>
                          <tr height="30"> 
                            <td align="center" class="border_in" style="border-top-style:none">합계금액</td>
                            <td class="border_in" style="border-top-style:none;font-size:12px;" align="center"><strong><?=$prtInfo['amount_tot']?></strong> <span style="font-size:80%">(VAT<?=$prtInfo['tax_added_txt']?>)</span></td>
                          </tr>
                        </table></td>
                    </tr>
                  </table></td>
                <td width="55%"><div class="sign_area"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr> 
                      <td class="border_in" width="18" align="center"><span style="line-height:38px">공<br />
                        급<br />
                        자</span></td>
                      <td><table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
                          <tr height="30"> 
                            <td width="47" align="center" class="border_in">등록번호</td>
                            <td class="border_in" align="center"><span style="font-size:13px;font-weight:bold"><?=$prtCompany['taxid']?></span></td>
                          </tr>
                          <tr height="30"> 
                            <td align="center" class="border_in" style="border-top-style:none">상 
                              호<br />
                              (법인명) </td>
                            <td><table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr> 
                                  <td class="border_in" style="border-top-style:none" align="center"><strong style="font-size:11px"><?=$prtCompany['company']?></strong></td>
                                  <td class="border_in" style="border-top-style:none" align="center" width="15">성<br />
                                    명</span></td>
                                  <td class="border_in" style="border-top-style:none" align="left">&nbsp;&nbsp;<strong style="font-size:11px"><?=$prtCompany['name']?></strong> (인)<?=$prtCompany['sign_img']?></td>
                                </tr>
                              </table></td>
                          </tr>
                          <tr height="30"> 
                            <td align="center" class="border_in" style="border-top-style:none">사업장<br />
                              주 소</td>
                            <td class="border_in" style="border-top-style:none" align="center"><?=$prtCompany['address']?></td>
                          </tr>
                          <tr height="30"> 
                            <td align="center" class="border_in" style="border-top-style:none">업 
                              태</td>
                            <td><table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr> 
                                  <td class="border_in" style="border-top-style:none" align="center"><?=$prtCompany['biz_type']?></td>
                                  <td class="border_in" style="border-top-style:none" width="15" align="center">종<br />
                                    목</td>
                                  <td class="border_in" style="border-top-style:none" align="center"><?=$prtCompany['biz_item']?></td>
                                </tr>
                              </table></td>
                          </tr>
                        </table></td>
                    </tr>
                  </table></div></td>
              </tr>
            </table></td>
        </tr>
        <tr> 
          <td><table width="100%" border="0" cellspacing="0" cellpadding="0" class="border_in" style="border-top-style:none;border-left-style:none">
              <tr height="20"> 
                <td class="border_in" style="border-top-style:none;border-left-style:none" align="center">월</td>
                <td class="border_in" style="border-top-style:none;border-left-style:none" align="center">일</td>
                <td class="tl_dot" style="border-top-style:none" align="center">품 &nbsp; &nbsp; 목</td>
                <td class="tl_dot" style="border-top-style:none" align="center">규 격</td>
                <td class="tl_dot" style="border-top-style:none" align="center">수 량</td>
                <td class="tl_dot" style="border-top-style:none" align="center">단 가</td>
                <td class="tl_dot" style="border-top-style:none" align="center">구 분</td>
                <td class="tl_dot" style="border-top-style:none" align="center">금 액</td>
                <td class="tl_dot" style="border-top-style:none" align="center">비 고</td>
              </tr>
  <?php for ($i=0, $maxi=count($prtArticle); $i<$maxi; $i++) { ?>
              <tr height="20">
                <td class="lb_dot" style="border-top-style:none;border-left-style:none" align="center"><?=$prtArticle[$i]['month']?></td>
                <td class="lb_dot" style="border-top-style:none" align="center"><?=$prtArticle[$i]['day']?></td>
                <td class="lb_dot" style="border-top-style:none" align="center"><?=$prtArticle[$i]['article']?></td>
                <td class="lb_dot" style="border-top-style:none" align="center"><?=$prtArticle[$i]['type']?></td>
                <td class="lb_dot" style="border-top-style:none" align="right"><?=$prtArticle[$i]['pcs']?> &nbsp; </td>
                <td class="lb_dot" style="border-top-style:none" align="right"><?=$prtArticle[$i]['price_each']?> &nbsp; </td>
                <td class="lb_dot" style="border-top-style:none" align="right"><?=$prtArticle[$i]['pay_type']?> &nbsp; </td>
                <td class="lb_dot" style="border-top-style:none" align="right"><?=$prtArticle[$i]['amount']?> &nbsp; </td>
                <td class="lb_dot" style="border-top-style:none" align="center"><?=$prtArticle[$i]['note']?></td>
              </tr>
  <?php } ?>
            </table>
          </td>
        </tr>
        <tr>
          <td>
            <table width="100%" border="0" cellspacing="0" cellpadding="0" style="border-top-style:none;">
              <tr height="20">
                <td width="50" style="border-right:1px solid black" align="center">영수금액</td>
                <td style="border-right:1px solid black">&nbsp; <strong style="font-size:11px"><?=$prtInfo['paid_tot']?></strong></td>
                <td width="50" style="border-right:1px solid black" align="center">청구금액</td>
                <td>&nbsp; <strong style="font-size:11px"><?=$prtInfo['receivable_tot']?></strong></td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
  <?php if ($copy_ == 1 && $prtPair == 'BOTH') { ?>
    <td width="50" align="center">
      <table border="0" height="100%" width="50">
        <tr height="100%">
          <td class="">&nbsp;</td>
        </tr>
      </table>
      <script type="text/javascript">
        window.resizeTo (1010, 690);
      </script>
    </td>
  <?php } ?>
  <?php if ($prtPair == 'SINGLE') break; ?>
<?php } ?>
  </tr>
</table>
</body>

</html>