
var TableManaged = function () {

    return {
        _table : null,

        //main function to initiate the module
        init: function (province,city,district,commName) {

            var _province = '';
            var _city = '';
            var _district = '';
            var _commName = '';

            if (province) {
                _province = province;
            }
            if (city) {
                _city = city;
            }
            if (district) {
                _district = district;
            }
            if (commName) {
                _commName = commName;
            }

            if(this._table)
            {
                this._table.fnReloadAjax("communityAction!queryCommunities.action?province="+_province+"&city="+_city+"&district="+_district+"&commName="+_commName);
            }
            if (!jQuery().dataTable) {
                return;
            }

            this._table =  $('#sample_1').dataTable({
                "search":false,
                "bDestroy":true,
                "bRetrieve": true,
                'bStateSave': true,
                "aoColumns": [
                    {"mRender":function(data,type,row){
                        return  '<div class="checker"><span><input type="checkbox" class="checkboxes" /></span></div>'
                    },"sClass": "hidden-480","bSortable": false,"mDataProp":"commId","mData" : "commId"},
                    {"mDataProp":"province","sClass": "hidden-480", "mData" : "province"},
                    {"mDataProp":"city","sClass": "hidden-480", "mData" : "city"},
                    {"mDataProp":"district","sClass": "hidden-480","mData" : "district"},
                    {"mDataProp":"commName","sClass": "hidden-480", "mData" : "commName"},
                    {"bSortable": false,"mDataProp":"commDesc","sClass": "hidden-480 ", "mData" : "commDesc"},
                    {"bSortable": false,"mDataProp":"commLongitud","sClass": "hidden-480 ", "mData" : "commLongitud"},
                    {"bSortable": false,"mDataProp":"commLatitude","sClass": "hidden-480 ", "mData" : "commLatitude"},
                    {"bSortable": false,"mDataProp":"disNames","sClass": "hidden-480 ", "mData" : "disNames"},
                    {"mRender":function(data,type,row){
                        return '<div><button onclick="updateComm()" class="btn"><i class="icon-edit"  alt="修改"></i></button> ' +
                            '<button class="btn" onclick="createMsgMainWin(\'确认删除这条记录吗?\',function(){delComm('+data+');});" ><i class="icon-remove" alt="删除"></i></button> '+
                            '<button class="btn" onclick="detailComm('+data+');" ><i class="icon-file-text" alt="详情"></i></button></div>';
                    },"sClass": "hidden-480","bSortable": false,"mDataProp":"commId","mData" : "commId"}

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
                sAjaxSource:"communityAction!queryCommunities.action?province="+_province+"&city="+_city+"&district="+_district+"&commName="+_commName,
                "fnServerData": function (sSource, aoData, fnCallback) {
                    $.ajax({

                        "type": 'post',

                        "url": sSource,

                        "dataType": "json",

                        "data": {

                            aoData: JSON.stringify(aoData)

                        },

                        "success": function (resp) {
                            fnCallback(resp);

                        }

                    });

                }
            });

            jQuery('#sample_1 .group-checkable').change(function () {
                //var set = jQuery(this).attr("data-set");

                //alert(jQuery("#sample_1").find("input[type='checkbox']").length);

                var checked = jQuery(this).is(":checked");
                jQuery("#sample_1").find("input[type='checkbox']").each(function () {
                    if (checked) {

                        $(this).get(0).checked = 'true';
                        //$(this).attr("checked", true);
                    } else {
                        $(this).get(0).checked = 'false';
                        //$(this).attr("checked", false);
                    }
                });
                jQuery.uniform.update(set);
            });

            jQuery('#sample_1_wrapper .dataTables_filter').css("display","none");
            jQuery('#sample_1_wrapper .dataTables_length select').addClass("m-wrap small"); // modify table per page dropdown


        }

    };

}();

jQuery.validator.addMethod("longLatitude", function(value, element) {
    var length = value.length;
    return this.optional(element) || (/^\d+\.?\d*,\d+\.?\d*$/.test(value));
}, "请正确填写经纬度。");

var FormValidation = function () {

    return {
        //main function to initiate the module
        init: function () {

            var form1 = $('#commnuityForm');

            form1.validate({
                errorElement: 'span', //default input error message container
                errorClass: 'help-inline', // default input error message class
                focusInvalid: false, // do not focus the last invalid input
                ignore: "",
                rules: {
                    provinceId: {
                        required: true
                    },
                    cityId: {
                        required: true
                    },
                    regionalId: {
                        required: true
                    },
                    commName: {
                        required: true
                    },
                    commLongLatitude: {
                        required: true,
                        longLatitude: true
                    },
                    disId :{
                        required: true
                    }
                },

                highlight: function (element) { // hightlight error inputs
                    $(element)
                        .closest('.help-inline').removeClass('ok'); // display OK icon
                    $(element)
                        .closest('.control-group').removeClass('success').addClass('error'); // set error class to the control group
                },

                unhighlight: function (element) { // revert the change dony by hightlight
                    $(element)
                        .closest('.control-group').removeClass('error'); // set error class to the control group
                },

                success: function (label) {
                    label
                        .addClass('valid').addClass('help-inline ok') // mark the current input as valid and display OK icon
                        .closest('.control-group').removeClass('error').addClass('success'); // set success class to the control group
                }
            });

        }

    };

}();