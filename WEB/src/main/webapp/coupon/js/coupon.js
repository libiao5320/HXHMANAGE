
var TableManaged = function () {
    alert(222);
    return {
        _table : null,

        //main function to initiate the module
        init: function () {
            if(this._table)
            {
                this._table.fnReloadAjax("couponAction!queryCoupon.action");
            }
            if (!jQuery().dataTable) {
                return;
            }

            this._table =  $('#sample_1').dataTable({
                "search":false,
                "bDestroy":true,
                "bRetrieve": true,
                "aoColumns": [
                    {"mRender":function(data,type,row){
                        return  '<div class="checker"><span><input type="checkbox" class="checkboxes" /></span></div>'
                    },"sClass": "hidden-480","bSortable": false,"mDataProp":"couponId","mData" : "couponId"},
                    {"mDataProp":"couponId","sClass": "hidden-480", "mData" : "couponId"},
                    {"mDataProp":"couponName","sClass": "hidden-480", "mData" : "couponName"},
                    {"mDataProp":"couponPrice","sClass": "hidden-480 ", "mData" : "couponPrice"},
                    {"mDataProp":"couponStart","sClass": "hidden-480","mData" : "couponStart"},
                    {"mDataProp":"couponEnd","sClass": "hidden-480", "mData" : "couponEnd"},
                    {"mDataProp":"couponCreate","sClass": "hidden-480 ", "mData" : "couponCreate"},
                    {"mDataProp":"couponStatus","sClass": "hidden-480", "mData" : "couponStatus"},
                    {"mRender":function(data,type,row){
                        return '<div><button onclick="updateCoupon()" class="btn"><i class="icon-edit"  alt="修改"></i></button> ' +
                            '<button class="btn" onclick="delCoupon" class="btn"><i class="icon-remove" alt="删除"></i></button> '
                    },"sClass": "hidden-480","bSortable": false,"mDataProp":"couponId","mData" : "couponId"}
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
                sAjaxSource:"couponAction!queryCoupon.action",
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
                    commLatitude: {
                        required: true,
                        number: true
                    },
                    commLongitud: {
                        required: true,
                        number: true
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