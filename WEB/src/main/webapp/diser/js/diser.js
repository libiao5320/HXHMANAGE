
var TableManaged = function () {

    return {
        _table : null,

        //main function to initiate the module
        init: function (type) {

            var _type = type;

            if(this._table&&_type != 4)
            {
                this._table.fnReloadAjax("diserAction!queryDiser.action");
            } else if(_type && _type == 4) {
                var  _url =  "diserAction!queryDiserByCondition.action?1=1";
                var _workNum = $("#workNum").val();
                var _diserName = $("#diserName").val();
                var _phone = $("#phone").val();

                if (_phone)
                    _url += "&phone=" + _phone;
                if (_workNum)
                    _url += "&workNum=" + _workNum;
                if (_diserName)
                    _url += "&diserName=" + _diserName;

                this._table.fnReloadAjax(_url);
                closeloading();
                return;
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

                        return  '<div class="checker"><span><input type="checkbox" class="checkboxes" value="1" /></span></div>'
                    },"sClass": "hidden-480","bSortable": false,"mDataProp":"disId","mData" : "disId"},
                    {"bSortable": false,"mDataProp":"workNum","sClass": "hidden-480", "mData" : "workNum"},
                    {"mDataProp":"disName","sClass": "hidden-480", "mData" : "disName"},
                    {"mDataProp":"disPhone","sClass": "hidden-480", "mData" : "disPhone"},
                    {"mDataProp":"disPhoto","sClass": "hidden-480", "mData" : "disPhoto","mRender":function(data){
                        if(data==''){
                            return '未上传';
                        }else{
                            return '<img src="Upload/images/'+data+'"/  style=width:50px height:100px>';
                        }

                    }},
                    {"mDataProp":"disStatus","sClass": "hidden-480", "mData" : "disStatus","mRender":function (data){
                        if (data == 1) {
                            return '<span class="label label-success">启用</span>';
                        } else if (data == 2) {
                            return '<span class="label label-danger">停用</span>';
                        } else {
                            return data;
                        }
                    }},
                    {"mRender":function(data,type,row){
                        /*    return  '<div class="btn-group" style="font-size: 15px;">'+
                            '<button onclick="updateDiser()" class="btn green">修改 </button> '+
                            '<button onclick="delDiser('+data+')" class="btn red">删除 </button> '+
                            '<button onclick="diserComm('+data+')" class="btn green">关联小区</button> '+
                            '</div>'*/
                        return '<button class="btn" onclick="updateDiser()" ><i class="icon-edit"  alt="修改"></i></button> <button class="btn" ' +
                            ' onclick="createMsgMainWin(\'确认删除这条记录吗?\',function(){delDiser('+data+');});" ><i class="icon-remove"  ' +
                            'alt="删除"></i></button> <button class="btn" onclick="diserDetail('+data+')" ><i class="icon-file-text" ' +
                            ' alt="详情"></i></button> '

                    },"sClass": "hidden-480","bSortable": false,"mDataProp":"disId","mData" : "disId"}
                ],
                "aLengthMenu": [
                    [5, 15, 20, -1],
                    [5, 15, 20, "All"] // change per page values here
                ],

                "iDisplayLength": 15,
                "sDom": "<'row-fluid'<'span6'l><'span6'f>r>t<'row-fluid'<'span6'i><'span6'p>>",
                "sPaginationType": "bootstrap",
                "oLanguage":

                {// 汉化、
                    "sProcessing": "正在加载数据...",
                    "sLengthMenu": "_MENU_&nbsp;条记录 ",
                    "sZeroRecords": "没有您要搜索的内容",
                    "sInfo": "从_START_ 到 _END_ 条记录——总记录数为 _TOTAL_ 条",
                    "sInfoEmpty": "记录数为0",
                    "sInfoFiltered": "(全部记录数 _MAX_  条)",
                    "sInfoPostFix": "",
              /*      "sSearch": "搜索",*/
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
                sAjaxSource:"diserAction!queryDiser.action?type="+_type,
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

            jQuery('#sample_editable_1 .dataTables_filter').css("display","none");
            jQuery('#sample_editable_1 .dataTables_length select').addClass("m-wrap small"); // modify table per page dropdown
        
        }
    };
}();



var DiserCommTableManaged = function () {

    return {
        _table : null,

        //main function to initiate the module
        init: function (type) {
            var _type = type;
            if(this._table)
            {
                this._table.fnReloadAjax("diserAction!queryCommByDisId.action?disId="+_type);
            }
            if (!jQuery().dataTable) {
                return;
            }

            this._table =  $('#sample_1').dataTable({
                "bDestroy":true,
                "search":false,
                "bRetrieve": true,
                "aoColumns": [
                    {"mRender":function(data,type,row){

                        return  '<div class="checker"><span><input type="checkbox" class="checkboxes" value="1" /></span></div>'
                    },"sClass": "hidden-480","bSortable": false,"mDataProp":"commId","mData" : "commId"},
                    {"bSortable": false,"mDataProp":"disCity","sClass": "hidden-480", "mData" : "disCity"},
                    {"mDataProp":"disComm","sClass": "hidden-480", "mData" : "disComm"},
                    {"mRender":function(data,type,row){
                        return '<button class="btn" ' +
                            ' onclick="createMsgMainWin(\'确认删除这条记录吗?\',function(){delCommRel('+data+');});" ><i class="icon-remove"  ' +
                            'alt="删除"></i></button> '

                    },"sClass": "hidden-480","bSortable": false,"mDataProp":"commId","mData" : "commId"}
                ],
                "aLengthMenu": [
                    [5, 15, 20, -1],
                    [5, 15, 20, "All"] // change per page values here
                ],

                "iDisplayLength": 15,
                "sDom": "<'row-fluid'<'span6'l><'span6'f>r>t<'row-fluid'<'span6'i><'span6'p>>",
                "sPaginationType": "bootstrap",
                "oLanguage":

                {// 汉化、
                    "sProcessing": "正在加载数据...",
                    "sLengthMenu": "_MENU_&nbsp;条记录 ",
                    "sZeroRecords": "没有您要搜索的内容",
                    "sInfo": "从_START_ 到 _END_ 条记录——总记录数为 _TOTAL_ 条",
                    "sInfoEmpty": "记录数为0",
                    "sInfoFiltered": "(全部记录数 _MAX_  条)",
                    "sInfoPostFix": "",
      /*              "sSearch": "搜索",*/
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
                sAjaxSource:"diserAction!queryCommByDisId.action?type="+_type,
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

var FormFileUpload = function () {
    return {
        //main function to initiate the module
        init: function () {
            // Initialize the jQuery File Upload widget:
            $('#diserForm').fileupload({
                url: 'diserAction!diserFileUpload.action'
            });
            $.ajax({
                url: $('#diserForm').fileupload('option', 'url'),
                dataType: 'json',
                context: $('#fileupload')[0],
                maxFileSize: 5000000,
                acceptFileTypes: /(\.|\/)(gif|jpe?g|png)$/i,
                process: [{
                    action: 'load',
                    fileTypes: /^image\/(gif|jpeg|png)$/,
                    maxFileSize: 20000000 // 20MB
                }, {
                    action: 'resize',
                    maxWidth: 1440,
                    maxHeight: 900
                }, {
                    action: 'save'
                }
                ]
            }).done(function (result) {
                $(this).fileupload('option', 'done')
                    .call(this, null, {
                        result: result
                    });
            });

            // Upload server status check for browsers with CORS support:
            if ($.support.cors) {
                $.ajax({

                    url: 'diserAction!diserFileUpload.action',
                    type: 'HEAD'
                }).fail(function () {
                    $('<span class="alert alert-error"/>')
                        .text('Upload server currently unavailable - ' +
                        new Date())
                        .appendTo('#fileupload');
                });
            }

            // initialize uniform checkboxes
            App.initUniform('.fileupload-toggle-checkbox');
        }

    };

}();



var FormValidation = function () {

    return {
        //main function to initiate the module
        init: function () {

            var form1 = $('#diserForm');
            var form2 = $('#diserUpdateForm');

            form1.validate({
                errorElement: 'span', //default input error message container
                errorClass: 'help-inline', // default input error message class
                focusInvalid: false, // do not focus the last invalid input
                ignore: "",
                rules: {
                    disName: {
                        required: true
                    },
                    disPhone: {
                        required: true,
                        number: true,
                        minlength: 11
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
          form2.validate({
                        errorElement: 'span', //default input error message container
                        errorClass: 'help-inline', // default input error message class
                        focusInvalid: false, // do not focus the last invalid input
                        ignore: "",
                        rules: {
                            workNum: {
                                disabled: true
                            },
                            disName: {
                                disabled: true
                            },
                            disPhone: {
                                required: true,
                                number: true,
                                minlength: 11
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