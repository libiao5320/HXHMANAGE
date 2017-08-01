
var TableManaged = function () {

    return
    {
        _table : null,

        //main function to initiate the module
        init: function (type)
    {

            showloading();

            var _type = type;


            if(this._table)
            {

                var _url = "orderAction!queryOrders.action?1=1";

                if(_type && _type!=4) {




                    this._table.fnReloadAjax(_url + "&type=" + _type);
                    return ;
                }
                else if(_type && _type == 4) {

                    _url =  "orderAction!queryOrdersByCondition.action?1=1";
                    var _phone = $("#phone").val();
                    var _beginDate = $("#beginDate").val();
                    var _endDate = $("#endDate").val();
                    var _orderSeq = $("#orderSeq").val();


                    if (_phone)
                        _url += "&phone=" + _phone;
                    if (_beginDate)
                        _url += "&beginDate=" + _beginDate;
                    if (_endDate)
                        _url += "&endDate=" + _endDate;
                    if (_orderSeq)
                        _url += "&orderSeq=" + _orderSeq;

                }


                this._table.fnReloadAjax(_url);


                closeloading();
                return;



            }
            if (!jQuery().dataTable) {
                return;
            }

            if(jQuery().datepicker)
            {
                $('.date-picker').datepicker({ format: 'yy-mm-dd' });
            }

            // begin first table
            //if(this._table)
            //this._table.destroy();


            this._table =  $('#sample_1').dataTable
            ({
                "search":false,
                "bDestroy":true,
                "bRetrieve": true,
                "bStateSave": true,
                "aoColumns": [
                    {"mRender":function(data,type,row){

                        return  '<div class="checker"><span><input type="checkbox" class="checkboxes" value="'+data+'" /></span></div>'
                    },"sClass": "hidden-480","bSortable": false,"mDataProp":"orderId","mData" : "orderId"},
                    {"bSortable": false,"mDataProp":"orderSeq","sClass": "hidden-480", "mData" : "orderSeq"},
                    {"mDataProp":"orderPhone","sClass": "hidden-480", "mData" : "orderPhone"},
                    {"bSortable": false,"mDataProp":"sendAdd","sClass": "hidden-480","mData" : "sendAdd"},
                    {"mDataProp":"orderDate","sClass": "hidden-480", "mData" : "orderDate"},
                    {"bSortable": false,"mDataProp":"orderStatus","sClass": "hidden-480 ", "mData" : "orderStatus"},

                    {"bSortable": false,"mDataProp":"statusDesc","sClass": "hidden-480 ", "mData" : "statusDesc"},


                    {"bSortable": false,"mDataProp":"orderComment","sClass": "hidden-480 ", "mData" : "orderComment"},
                    {"bSortable": false,"mDataProp":"orderVoicePath",
                        "mRender":function(data,type,row){

                            return data == null?"无":'<button class="btn" onclick="TableManaged.playVoice(this,\'' +data
                            +'\')"><i class="icon-play"></i></button>';
                        },

                        "sClass": "hidden-480 center", "mData" : "orderVoicePath"},
                    {"bSortable": false,
                        "mRender":function(data,type,row){

                            return '<button class="btn" onclick="createMsgMainWin(\'<input id=statusDesc type=text placeholder=管理备注 class=m-wrap huge>\',function(){TableManaged.addCurentStatusDesc('+data+')})"  ><i class="icon-edit"   alt="修改"></i></button> <button class="btn"  onclick="createMsgMainWin(\'确认删除这条记录吗?\',function(){TableManaged.delOrder('+data+');});" ><i class="icon-remove"  alt="删除"></i></button> <button class="btn" onclick="javascript:TableManaged.orderDetail('+data+');" ><i class="icon-file-text"  alt="详情"></i></button> ';
                        },

                        "sClass": "hidden-480 center", "mDataProp":"orderId","mData" : "orderId"}


                ],
                "aLengthMenu": [
                    [5, 15, 20, -1],
                    [5, 15, 20, "All"] // change per page values here
                ],
                // set the initial value
                "iDisplayLength": 15,
                "sDom": "<'row-fluid'<'span6'l><'span6'f>r>t<'row-fluid'<'span6'i><'span6'p>>",
                "sPaginationType": "bootstrap",
                "oLanguage": {// 汉化、
                    "sProcessing": "正在加载数据...",
                    "sLengthMenu": "_MENU_&nbsp;条记录 ",
                    "sZeroRecords": "没有您要搜索的内容",
                    "sInfo": "从_START_ 到 _END_ 条记录——总记录数为 _TOTAL_ 条",
                    "sInfoEmpty": "记录数为0",
                    "sInfoFiltered": "(全部记录数 _MAX_  条)",
                    "sInfoPostFix": "",
                    "sSearch": "搜索",
                    "sUrl": "",
                    "oPaginate": {
                        "sFirst": "第一页",
                        "sPrevious": " 上一页 ",
                        "sNext": " 下一页 ",
                        "sLast": " 最后一页 "
                    },
                    "aoColumnDefs": [{
                        'bSortable': false,
                        'aTargets': [0]
                    }
                    ]

                },
                "bProcessing": true,
                sAjaxSource:"orderAction!queryOrders.action?type="+_type,
                "fnServerData": function (sSource, aoData, fnCallback) {

                    $.ajax({

                        "type": 'post',

                        "url": sSource,

                        "dataType": "json",

                        "data": {

                            aoData: JSON.stringify(aoData)

                        },

                        "success": function (resp) {
                            closeloading();
                            fnCallback(resp);

                        }

                    });

                }
            });

            jQuery('#sample_1 .group-checkable').change(function () {
                //var set = jQuery(this).attr("data-set");

                //alert(jQuery("#sample_1").find("input[type='checkbox']").length);

                var checked = jQuery(this).is(":checked");
                jQuery("#sample_1").find("input[type='checkbox']").each(function (i,o) {
                    if (checked) {
                        $(o).parent().addClass("checked");
                        $(o).get(0).checked = true;
                        //$(this).attr("checked", true);
                    } else {
                        $(o).parent().removeClass("checked");
                        $(o).get(0).checked = false;
                        //$(this).attr("checked", false);
                    }
                });
                //jQuery.uniform.update(set);
            });

            jQuery('#sample_1_wrapper .dataTables_filter').css("display","none");
            jQuery('#sample_1_wrapper .dataTables_length select').addClass("m-wrap small"); // modify table per page dropdown


        }
        ,

        playVoice  : function(obj,file){



            var playObj = $("#soundPlay");

            $.get("orderAction!palyVoiceFromFtp.action",{"fileName":file},function(data){






                playObj.attr("src", data.voicePath);

                $("#sample_1").find(".icon-pause").each(function(i,o){

                    $(o).removeClass("icon-pause");
                    $(o).addClass("icon-play");
                })
                if (!playObj.get(0).ended) {
                    playObj.get(0).play();
                    $(obj).find("i").removeClass("icon-play");
                    $(obj).find("i").addClass("icon-pause");

                }
                else {
                    playObj.get(0).pause();
                    $(obj).find("i").removeClass("icon-pause");
                    $(obj).find("i").addClass("icon-play");
                }
                playObj.get(0).addEventListener("ended", function () {
                    $(obj).find("i").removeClass("icon-pause");
                    $(obj).find("i").addClass("icon-play");
                }, false);


            },"json")





        },


        delOrder:function(orderId){
            showloading();
            $.post("orderAction!delOrder.action",{"orderId":orderId},function(data){
                    var success = data.success;
                    var flag = data.flag;


                    if(success)
                    {

                        if(flag)
                        {
                            closeloading();
                            $('#msgMain_sign').modal('hide');
                            createAlertMsgMainWin("订单删除成功");

                            TableManaged._table.fnReloadAjax();
                        }
                        else
                        {
                            createAlertMsgMainWin("订单删除失败");
                        }



                    }
                       else
                        {
                            closeloading();
                            createAlertMsgMainWin("订单删除失败");
                        }


            },"json");

        },
        orderDetail:function(orderId){

            showloading();
            $.post("orderAction!queryOrderDetail.action",{"orderId":orderId},function(data){
                var orderInfo = data.orderInfo;
                var proList  = data.proList;
                var statusList  = data.statusList;
                var userInfo  = data.userInfo;



                $("#lable_orderSeq").html(orderInfo.orderSeq);
                $("#custName_lab").html("姓名："+userInfo.userName);
                $("#custPhone_lab").html("手机："+userInfo.userPhone);
                $("#custAdd_lab").html("地址:"+orderInfo.sendAdd);
                $("#orderDate_lab").html("订单日期："+orderInfo.orderDate);
                $("#orderBaseInfo_lab").html("订单备注:"+orderInfo.baseInfo);

                $("#orderList").toggle();
                $("#orderDetailContain").toggle();


                $("#proTab").empty();
                if(!proList || proList.length == 0)
                {
                    var _html  = "<tr><td colspan='6' align='centerud '> 无产品信息  </td></tr>"
                    $("#proTab").append(_html);
                }
                else
                {
                    for(var i = 0 ; i <proList.length ; i++)
                    {
                        var pro  = proList[i];
                        var _tmpTr = "<tr>";
                        _tmpTr += "<td> "+(i+1)+ " </td>";
                        _tmpTr += "<td> "+pro['PRO_NAME']+ " </td>";
                        _tmpTr += "<td class='hidden-480'> "+pro['TYPE_NAME']+ " </td>";
                        _tmpTr += "<td class='hidden-480> "+pro['COUNT']+ " </td>";
                        _tmpTr += "<td class='hidden-480> "+pro['PRO_REALPRICE']+ " </td>";
                        _tmpTr += "<td> "+parseInt(pro['COUNT'])*parseFloat(pro['PRO_REALPRICE'])+ " </td>";
                        _tmpTr += "</tr>";
                        $("#proTab").append(_tmpTr);


                    }
                }

                var orderStatusUL = $("#orderStatusUL");
                orderStatusUL.empty();
                var _html = "";
                for (var i = 0; i < statusList.length; i++ ) {
                    var status = statusList[i];
                    _html = '<li class="timeline-yellow">' +
                    '<div class="timeline-time"><span class="date">'+status.statusTime.substring(0,16)+'</span>'+
                    '<span class="time"></span></div><div class="timeline-icon"><i class="icon-trophy"></i></div>' +
                    '<div class="timeline-body"><div class="timeline-content">' +
                    '<img class="timeline-img pull-left" src="media/image/2.jpg" alt="">'+status.statusName + '('+ status.statusDesc+
                    ')</div><div class="timeline-footer"><a href="#" class="nav-link pull-right">Read more <i class="m-icon-swapright m-icon-white"></i> ' +
                    '</a></div></div></li>';


                }
                orderStatusUL.append(_html);
                closeloading();

            },"json");


        },

        addCurentStatusDesc:function(orderId){
            var staDesc = $("#statusDesc").val();


            $.post("orderAction!addCurentStatusDesc.action",{"orderId":orderId,"staDesc":staDesc},function(data){

                    if(data.success) {
                        if (data.flag) {
                            $('#msgMain_sign').modal('hide');
                            TableManaged._table.fnReloadAjax();
                            createAlertMsgMainWin("成功：添加状态描述");
                        }
                        else {
                            $('#msgMain_sign').modal('hide');
                            TableManaged._table.fnReloadAjax();
                            createAlertMsgMainWin("失败：添加状态描述");

                        }

                    }
                    else{
                        $('#msgMain_sign').modal('hide');
                        createAlertMsgMainWin("失败：添加状态描述");
                    }
            },"json");
        }

        //queryByCondition:function(){
        //
        //}

    };

}();