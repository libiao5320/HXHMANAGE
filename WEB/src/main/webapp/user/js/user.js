
var TableManaged = function () {

    return {
        _table : null,

        //main function to initiate the module
        init: function (userName,userPhone,userRegStart,userRegEnd) {

            var _userName = '';
            var _userPhone = '';
            var _userRegStart = '';
            var _userRegEnd = '';

            if (userName) {
                _userName = userName;
            }

            if (userPhone) {
                _userPhone = userPhone;
            }

            if (userRegStart) {
                _userRegStart = userRegStart;
            }

            if (userRegEnd) {
                _userRegEnd = userRegEnd;
            }

            if(this._table)
            {
                this._table.fnReloadAjax("userAction!queryUsers.action?userName="+_userName+"&userPhone="+_userPhone+"&userRegStart="+_userRegStart+"&userRegEnd="+_userRegEnd);
            }
            if (!jQuery().dataTable) {
                return;
            }

            this._table =  $('#sample_1').dataTable({
                "bDestroy":true,
                "bRetrieve": true,
                "aoColumns": [
                    {"mRender":function(data,type,row){

                        return  '<div class="checker"><span><input type="checkbox" class="checkboxes" /></span></div>'
                    },"sClass": "hidden-480","bSortable": false,"mDataProp":"userId","mData" : "userId"},
                    {"mDataProp":"userName","sClass": "hidden-480", "mData" : "userName"},
                    {"mDataProp":"userSex","sClass": "hidden-480", "mData" : "userSex","mRender":function (data){
                        if (data == 1) {
                            return '男';
                        } else if (data == 2) {
                            return '女';
                        } else {
                            return '';
                        }
                    }},
                    {"mDataProp":"userPhone","sClass": "hidden-480", "mData" : "userPhone"},
                    {"mDataProp":"userState","sClass": "hidden-480", "mData" : "userState","mRender":function (data){
                        if (data == 1) {
                            return '<span class="label label-success">启用</span>';
                        } else if (data == 2) {
                            return '<span class="label label-danger">停用</span>';
                        } else {
                            return '';
                        }
                    }},
                    {"mDataProp":"userRegdate","sClass": "hidden-480", "mData" : "userRegdate"},
                    {"mRender":function(data){
                        return '<button onclick="updateUser()" class="btn"><i class="icon-edit"  alt="修改"></i></button> ';
                    },"sClass": "hidden-480","bSortable": false,"mDataProp":"userId","mData" : "userId"}

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
                sAjaxSource:"userAction!queryUsers.action?userName="+_userName+"&userPhone="+_userPhone+"&userRegStart="+_userRegStart+"&userRegEnd="+_userRegEnd,
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

    };

}();

jQuery.validator.addMethod("isMobile", function(value, element) {
    var length = value.length;
    return this.optional(element) || (length == 11 && /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/.test(value));
}, "请正确填写手机号码。");

var FormValidation = function () {

    return {
        //main function to initiate the module
        init: function () {

            var form1 = $('#editForm');

            form1.validate({
                errorElement: 'span', //default input error message container
                errorClass: 'help-inline', // default input error message class
                focusInvalid: false, // do not focus the last invalid input
                ignore: "",
                rules: {
                    userName: {
                        required: true
                    },
                    userPhone: {
                        isMobile: true,
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