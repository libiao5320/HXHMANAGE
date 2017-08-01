//��ȡ��ǰ��ַ���磺 http://localhost:8083/uimcardprj/share/meun.jsp
var curWwwPath=window.document.location.href;

//��ȡ������ַ֮���Ŀ¼���磺 uimcardprj/share/meun.jsp
var pathName=window.document.location.pathname;
var pos=curWwwPath.indexOf(pathName);

//��ȡ������ַ���磺 http://localhost:8083
var localhostPaht=curWwwPath.substring(0,pos);

//��ȡ��"/"����Ŀ�����磺/uimcardprj
var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
var finalUrl=localhostPaht+projectName;


var sessionStorage  = window.sessionStorage;




var createMsgMainWin=function (msg,fun){



    var msgWinHtml="";

    var tmpMsg = $("#msgMain_sign");

    if(!tmpMsg.get(0)) {
        msgWinHtml += '<div id="msgMain_sign" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true" >';
//    if(fun)
//    msgWinHtml+="<div class='modal-header'><button type='button' class='close' onclick='(function(){msgfun();})();' data-dismiss='modal' aria-hidden='true'>��</button><h3 id='myModalLabel'>ϵͳ��ʾ</h3></div>"
//    else
        msgWinHtml += '<div class="modal-header">';
        msgWinHtml += '<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>';
        msgWinHtml += '    <h3 id="myModalLabel1">消息确认</h3> </div>';


        msgWinHtml += ' <div class="modal-body">';
        msgWinHtml += '   <p>' + msg + '</p> </div>';
        msgWinHtml += ' <div class="modal-footer"><button class="btn" data-dismiss="modal" aria-hidden="true">取消</button><button id="sureBtn" data-dismiss="modal" class="btn yellow">确认</button>  </div> </div>'


        //var divObj = document.createElement("div");

        //
        //
        //
        //divObj.innerHTML = msgWinHtml;
        //var first = document.body.firstChild;
        //document.body.insertBefore(divObj, first);
        $(msgWinHtml).appendTo('body').modal();

        $("#sureBtn").unbind("click").one("click", function () {


            fun();

        });
        return ;
    }

    $("#msgMain_sign").find('p').html(msg);
    $("#msgMain_sign").modal();
    $("#sureBtn").unbind("click").one("click", function () {

        fun();

    });

    //lightBox = $('#msgMain_sign').lightbox_me({centered: true, onLoad: function () {
    //    $('#msgMain_sign').find('input:first').focus()
    //}, closeClick: false});
}


var createAlertMsgMainWin = function(msg)
{


    var msgWinHtml="";

    var tmpMsg = $("#alertMsg_Sign");

    if(!tmpMsg.get(0)) {
        msgWinHtml += '<div id="alertMsg_Sign" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2" aria-hidden="true" style="display: none;">';
//    if(fun)
//    msgWinHtml+="<div class='modal-header'><button type='button' class='close' onclick='(function(){msgfun();})();' data-dismiss='modal' aria-hidden='true'>��</button><h3 id='myModalLabel'>ϵͳ��ʾ</h3></div>"
//    else
        msgWinHtml += '<div class="modal-header">';
        msgWinHtml += '<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>';
        msgWinHtml += '<h3 id="myModalLabel2">提示信息</h3></div>';


        msgWinHtml += ' <div class="modal-body">';
        msgWinHtml += '   <p>' + msg + '</p> </div>';
        msgWinHtml += ' <div class="modal-footer"><button data-dismiss="modal" class="btn green">确认</button> </div> </div>'


        //var divObj = document.createElement("div");

        //
        //
        //
        //divObj.innerHTML = msgWinHtml;
        //var first = document.body.firstChild;
        //document.body.insertBefore(divObj, first);
        $(msgWinHtml).appendTo('body').modal();
        return ;
    }
    tmpMsg.find("p").html(msg);
    $("#alertMsg_Sign").modal();

}


var loadingHTML = '<div id="loading" class="prompt-box"><div class="spinner" ><div class="rect1"></div> <div class="rect2"></div> <div class="rect3"></div> <div class="rect4"></div> <div class="rect5"></div> </div></div>';

function showloading() {
    $(loadingHTML).appendTo("body");
}

function closeloading () {
    $(document).ajaxStop(function (){$("#loading").remove();});
}

if (jQuery.validator) {
    jQuery.extend(jQuery.validator.messages, {
        required: "必选字段",
        remote: "请修正该字段",
        email: "请输入正确格式的电子邮件",
        url: "请输入合法的网址",
        date: "请输入合法的日期",
        dateISO: "请输入合法的日期 (ISO).",
        number: "请输入合法的数字",
        digits: "只能输入整数",
        creditcard: "请输入合法的信用卡号",
        equalTo: "请再次输入相同的值",
        accept: "请输入拥有合法后缀名的字符串",
        maxlength: jQuery.validator.format("请输入一个 长度最多是 {0} 的字符串"),
        minlength: jQuery.validator.format("请输入一个 长度最少是 {0} 的字符串"),
        rangelength: jQuery.validator.format("请输入 一个长度介于 {0} 和 {1} 之间的字符串"),
        range: jQuery.validator.format("请输入一个介于 {0} 和 {1} 之间的值"),
        max: jQuery.validator.format("请输入一个最大为{0} 的值"),
        min: jQuery.validator.format("请输入一个最小为{0} 的值")
    });
}

function clearData(id,exculde) {
    $("#"+id).find("input, select, textarea").each(function (){
        var tagName = $(this)[0].tagName;
        var type = $(this).attr('type');
        var name = $(this).attr('name');
        var isCheckbox = $(this).attr('isCheckbox');
        if (isCheckbox) {
            $('#'+name).toggleButtons("setState",true);
        }

        if (!(exculde && exculde[name])) {
            if (tagName=='INPUT') {
                $(this).val("");
            } else if (tagName=='SELECT' || tagName=='TEXTAREA') {
                $(this).val("");
            }
        }
    });
}

function loadData(id,jsonStr){
    var obj = jsonStr;
    var key,value,tagName,type,arr,isCheckbox;
    for(x in obj){
        key = x;
        value = obj[x];

        $("#"+id+" [name='"+key+"'],[name='"+key+"[]']").each(function(){
            tagName = $(this)[0].tagName;
            type = $(this).attr('type');
            isCheckbox = $(this).attr('isCheckbox');
            if(tagName=='INPUT'){
                if(type=='radio'){
                    $(this).attr('checked',$(this).val()==value);
                }else if(type=='checkbox'){
                    //arr = String(value).split(',');
                    //if (value == 1) {
                    //    $("#"+key).toggleButtons('setState',true);
                    //} else {
                    //    $("#"+key).toggleButtons('setState',false);
                    //}
                    //for(var i =0;i<arr.length;i++){
                    //    if(!$(this).val()||$(this).val()==arr[i]){
                    //        $(this).attr('checked',true);
                    //        break;
                    //    }
                    //}
                }else{
                    if (isCheckbox) {
                        if (value == 2) {
                            $('#'+key).toggleButtons("setState",false);
                        } else {
                            $('#'+key).toggleButtons("setState",true);
                            value = 1;
                        }
                    }
                    $(this).val(value);
                }
            }else if(tagName=='SELECT' || tagName=='TEXTAREA'){
                $(this).val(value);
            }

        });
    }
}


function refreshTable(oTable) {
    var table = oTable.dataTable();
    var oSettings = table.fnSettings();

    //Retrieve the new data with $.getJSON. You could use it ajax too
    $.getJSON(oSettings.sAjaxSource, oSettings.aoData, function( json ) {
        table.fnClearTable(this);

        for (var i=0; i<json.aaData.length; i++) {
            table.oApi._fnAddData(oSettings, json.aaData[i]);
        }

        oSettings.aiDisplay = oSettings.aiDisplayMaster.slice();
        table.fnDraw(false);
    });
}