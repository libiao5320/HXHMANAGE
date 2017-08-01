;
var Product = function () {

    return {

        _proTable: null,
        _proTypeTable:null,
        _attrTable : null,
        _typeList: [],
        initPage: function () {
            var _this = this;
            _this.initProList();
            _this.initProType();

            $("#js_searchBtn").on("click",function(){
                _this.initProList(1);
            })

            $("#js_protypeBtn").on("click",function(){

                $("#producttypeList").css("display","block");
                $("#proList").css("display","none");

            });
            $("#js_proBtn").on("click",function(){
                $("#proList").css("display","block");
                $("#producttypeList").css("display","none");

            });


            $("#js_addProBtn").on("click",function(){

                $("#addProModal").modal();

            });
            $("#js_addProTypeBtn").on("click",function(){

               $("#addProTypeModal").modal();
            });


            $("#js_addProAttrBtn").on("click",function(){
                $("#addProAttrModal").modal();
            })

            $("#js_addPro_submit").on("click",function(){


                var _proName = $("#js_addPro_proname").val();
                var _price = $("#js_addPro_price").val();
                var _realPrice = $("#js_addPro_realprice").val();
                var _type = $("#js_addPro_type").val();


                var _unit = $("#js_addPro_unit").val();

                if(!_proName || _proName.length <1)
                return ;
                if(!_unit || _unit.length <1)
                    return ;
                if(isNaN(_price))
                return ;
                if(isNaN(_realPrice))
                return ;



                $.post("productAction!addProduct.action",{"proName":_proName,"price":_price,"realprice":_realPrice,"type":_type,"unit":_unit},function(data){

                    var flag = data.flag;
                    var success = data.success;

                    if(success)
                    {

                        if(flag)
                        {

                            _this._proTable.fnReloadAjax();

                            $('#addProModal').modal('hide');
                            createAlertMsgMainWin("添加产品：成功！");

                        }
                        else
                        createAlertMsgMainWin("添加产品：失败！");
                    }
                    else
                        createAlertMsgMainWin("添加产品：失败！");



                },"json");

            });

            $("#js_addPro_cancel").on("click",function(){



                $('#addProModal').modal('hide');
            });



            $("#js_addProType_submit").on("click",function(){


                var _typeName = $("#js_addProType_typeName").val();





                $.post("productAction!addProductType.action",{"typeName":_typeName},function(data){

                    var flag = data.flag;
                    var success = data.success;

                    if(success)
                    {

                        if(flag)
                        {

                            _this._proTypeTable.fnReloadAjax();

                            $('#addProTypeModal').modal('hide');
                            createAlertMsgMainWin("添加产品类型：成功！");

                        }
                        else
                            createAlertMsgMainWin("添加产品类型：失败！");
                    }
                    else
                        createAlertMsgMainWin("添加产品类型：失败！");



                },"json");

            });


            $("#js_addProAttr_submit").on("click",function(){


                var _attrName = $("#js_addProAttr_AttName").val();
                var _proId = $("#js_addProAttr_ProId").val();





                $.post("productAction!addProAttr.action",{"attrName":_attrName,"proId":_proId},function(data){

                    var flag = data.flag;
                    var success = data.success;

                    if(success)
                    {

                        if(flag)
                        {

                           refreshTable(_this._attrTable);

                            $('#addProAttrModal').modal('hide');
                            createAlertMsgMainWin("添加衣物属性：成功！");

                        }
                        else
                            createAlertMsgMainWin("添加衣物属性：失败！");
                    }
                    else
                        createAlertMsgMainWin("添加衣物属性：失败！");



                },"json");

            });

            $("#js_addProAttr_cancel").on("click",function(){
                $('#addProAttrModal').modal('hide');
            })


            $("#js_addProType_cancel").on("click",function(){



                $('#addProTypeModal').modal('hide');
            });



            var  addProForm = $('#js_addproForm');
            addProForm.validate({
                errorElement: 'span', //default input error message container
                errorClass: 'help-inline', // default input error message class
                focusInvalid: false, // do not focus the last invalid input
                ignore: "",
                rules: {
                    js_addPro_proname: {
                        required: true
                    },
                    js_addPro_price: {
                        required: true,
                        number: true
                    },
                    js_addPro_realprice: {
                        required: true,
                        number: true
                    },
                    js_addPro_type: {
                        required: true
                    },
                    js_addPro_unit: {
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


            var  edProForm = $('#js_edproForm');
            edProForm.validate({
                errorElement: 'span',
                errorClass: 'help-inline',
                focusInvalid: false,
                ignore: "",
                rules: {
                    js_edPro_proname: {
                        required: true
                    },
                    js_edPro_price: {
                        required: true,
                        number: true
                    },
                    js_edPro_realprice: {
                        required: true,
                        number: true
                    },
                    js_edPro_type: {
                        required: true
                    },
                    js_edPro_unit: {
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


        },

        initProList: function (type) {
            var _this = this;


            if (this._proTable) {


                if (type == 1) {
                    var _url = "productAction!queryProductByCondition.action?1=1";
                    var proName = $("#js_proName").val();
                    var typeId = $("#qry_protype").find("option:selected").val();



                    if (proName)
                        _url += "&proName=" + proName;
                    if (typeId && typeId != -1)
                        _url += "&typeId=" + typeId;

                    this._proTable.fnReloadAjax(_url);


                    return;

                }


                else {
                    var _url  = 'productAction!initProductList.action';
                    this._proTable.fnReloadAjax(_url);
                    return ;
                }

            }
            else {
                _this._proTable = $('#sample_1').dataTable({
                    "search": false,
                    "bDestroy": true,
                    "bRetrieve": true,
                    "bStateSave": true,
                    "aoColumns": [
                        {"mDataProp": "PRO_ID", "sClass": "hidden-480", "bSortable": true, "mData": "PRO_ID"},
                        {"bSortable": false, "mDataProp": "PRO_NAME", "sClass": "hidden-480", "mData": "PRO_NAME"},
                        {"mDataProp": "TYPE_NAME", "sClass": "hidden-480", "mData": "TYPE_NAME"},
                        {"mDataProp": "PRO_IMG", "sClass": "hidden-480", "mData": "PRO_IMG", "bSortable": false},
                        {"bSortable": false, "mDataProp": "PRO_PRICE", "sClass": "hidden-480 ", "mData": "PRO_PRICE"},

                        {
                            "bSortable": false,
                            "mDataProp": "PRO_REALPRICE",
                            "sClass": "hidden-480 ",
                            "mData": "PRO_REALPRICE"
                        },
                        {
                            "bSortable": false,
                            "mDataProp": "PRO_UNIT",
                            "sClass": "hidden-480 ",
                            "mData": "PRO_UNIT"
                        },

                        {
                            "bSortable": false, "mDataProp": "PRO_ID",
                            "mRender": function (data, type, row) {

                                return '<a href=javascript:void(0); onclick=Product.queryAttr(' + data + ')  >衣物属性</a>';
                            },

                            "sClass": "hidden-480 center", "mData": "PRO_ID"
                        },
                        {
                            "bSortable": false,
                            "mDataProp": "PRO_STATUS",
                            "sClass": "hidden-480 ",
                            "mData": "PRO_STATUS",
                            "mRender": function (data, type, row) {

                                return data == 1 ? "正常" : "无效";
                            }
                        },
                        {
                            "bSortable": false,
                            "mRender": function (data, type, row) {

                                return '<button class="btn" onclick="Product.editPro('+data+')"  ><i class="icon-edit"   alt="修改"></i></button> <button class="btn"  onclick="createMsgMainWin(\'确认删除这条记录吗?\',function(){Product.delPro(' + data + ');});" ><i class="icon-remove"  alt="删除"></i></button>  ';
                            },

                            "sClass": "hidden-480 center", "mDataProp": "PRO_ID", "mData": "PRO_ID"
                        }


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
                    sAjaxSource: "productAction!initProductList.action?type=",
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
            }

            jQuery('#sample_1_wrapper .dataTables_filter').css("display","none");

        },
        initProType: function () {
            var _this = this;




            _this._proTypeTable = $('#sample_2').dataTable({
                "search": false,
                "bDestroy": true,
                "bRetrieve": true,
                "bStateSave": true,
                "aoColumns": [
                    {"mDataProp": "TYPE_ID", "sClass": "hidden-480", "bSortable": true, "mData": "TYPE_ID"},
                    {"bSortable": false, "mDataProp": "TYPE_NAME", "sClass": "hidden-480", "mData": "TYPE_NAME"},
                    {
                        "bSortable": false,
                        "mRender": function (data, type, row) {

                            return '<button class="btn" onclick="Product.editProTpe('+data+')"  ><i class="icon-edit"   alt="修改"></i></button> <button class="btn"  onclick="createMsgMainWin(\'确认删除这条记录吗?\',function(){Product.delProType(' + data + ');});" ><i class="icon-remove"  alt="删除"></i></button> ';
                        },

                        "sClass": "hidden-480 center", "mDataProp": "TYPE_ID", "mData": "TYPE_ID"
                    }


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
                sAjaxSource: "productAction!initAllProType.action",
                "fnServerData": function (sSource, aoData, fnCallback) {

                    $.ajax({

                        "type": 'post',

                        "url": sSource,

                        "dataType": "json",

                        "data": {

                            aoData: JSON.stringify(aoData)

                        },

                        "success": function (resp) {


                            $("#qry_protype").empty();
                            $("#js_addPro_type").empty();
                            $("#js_edPro_type").empty();



                                var l = resp.typeList;
                                _this._typeList = l;
                                $("#qry_protype").append("<option value='-1'>-不限制-</option>");
                                for (var i = 0; i < l.length; i++) {

                                    var o = l[i];
                                    var _html = "<option value='" + o['TYPE_ID'] + "'>" + o['TYPE_NAME'] + "</option>";
                                    $("#qry_protype").append(_html);
                                    $("#js_addPro_type").append(_html);
                                    $("#js_edPro_type").append(_html);
                                }





                            fnCallback(resp);

                        }

                    });

                }
            });



        },
        queryProAttr: function () {
        },
        editProTpe: function (typeId) {

            var _this = this;

            var _typeId = typeId;


            $.post("productAction!queryProductType.action",{"typeId":_typeId},function(data){

                var proType = data.productType;

                $("#js_edProType_typeName").val(proType.typeName);



                $("#edProTypeModal").modal();
                $("#js_edProType_cancel").one("click",function(){

                    $('#edProTypeModal').modal('hide');
                })

                $("#js_edProType_submit").one("click",function(){


                    var typename =   $("#js_edProType_typeName").val();




                    $.post("productAction!editProType.action",{"typeId":_typeId,"typeName":typename},function(data){

                        var succcess = data.success;
                        var flag = data.flag;


                        if(succcess)
                        {

                            if(flag)
                            {
                                $('#edProTypeModal').modal('hide');
                                createAlertMsgMainWin("衣物类型修改：成功");

                                _this._proTypeTable.fnReloadAjax();


                            }
                            else
                            {
                                $('#edProTypeModal').modal('hide');
                                createAlertMsgMainWin("衣物类型修改：失败");
                            }
                        }
                        else
                        {

                            $('#editProModal').modal('hide');
                            createAlertMsgMainWin("衣物修改：失败");
                        }




                    },"json");

                })


            },"json")

        },

        editProAttr: function (attrId) {

            var _this = this;

            var _attrId = attrId;


            $.post("productAction!queryAttrById.action",{"attrId":_attrId},function(data){

                var productAttr = data.productAttr;

                $("#js_edProAttr_AttName").val(productAttr.attrName);



                $("#edProAttrModal").modal();
                $("#js_edProAttr_cancel").one("click",function(){

                    $('#edProAttrModal').modal('hide');
                })

                $("#js_edProAttr_submit").one("click",function(){


                    var attrName =   $("#js_edProAttr_AttName").val();




                    $.post("productAction!editProAttr.action",{"attrId":_attrId,"attrName":attrName},function(data){

                        var succcess = data.success;
                        var flag = data.flag;


                        if(succcess)
                        {

                            if(flag)
                            {
                                $('#edProAttrModal').modal('hide');
                                createAlertMsgMainWin("衣物属性修改：成功");

                                refreshTable(_this._attrTable);


                            }
                            else
                            {
                                $('#edProAttrModal').modal('hide');
                                createAlertMsgMainWin("衣物类型修改：失败");
                            }
                        }
                        else
                        {

                            $('#edProAttrModal').modal('hide');
                            createAlertMsgMainWin("衣物修改：失败");
                        }




                    },"json");

                })


            },"json")

        },


        delProAttr:function(attrId){

            var _this = this;
            $.post("productAction!delProAttr.action",{"attrId":attrId},function(data){
                var success = data.success;
                var flag = data.flag;


                if(success)
                {

                    if(flag)
                    {
                        closeloading();
                        $('#msgMain_sign').modal('hide');
                        createAlertMsgMainWin("衣物属性删除：成功");
                        refreshTable(_this._attrTable);
                    }
                    else
                    {
                        createAlertMsgMainWin("衣物属性删除：失败");
                    }



                }
                else
                {

                    createAlertMsgMainWin("衣物属性删除：失败");
                }


            },"json");
        },

        editPro: function (proId) {
            var _this = this;
            var _proId = proId;
            $.post("productAction!queryProduct.action",{"proId":proId},function(data){

                var pro = data.product;

                $("#js_edPro_proname").val(pro.proName);
                $("#js_edPro_price").val(pro.proPrice);
                $("#js_edPro_realprice").val(pro.proRealprice);
                $("#js_edPro_type").val(pro.typeId);
                $("#js_edPro_unit").val(pro.proUnit);


                $("#editProModal").modal();
                $("#js_edPro_cancel").one("click",function(){

                    $('#editProModal').modal('hide');
                })




                $("#js_edPro_submit").on("click",function(){



                    var _proName  = $("#js_edPro_proname").val();
                    var _price =   $("#js_edPro_price").val();
                    var _realPrice =    $("#js_edPro_realprice").val();
                    var _typeId =   $("#js_edPro_type").val();
                    var _unit = $("#js_edPro_unit").val();




                    if(!_proName || _proName.length <1) {

                        return;
                    }
                    if(!_unit || _unit.length <1) {

                        return;
                    }
                    if(isNaN(_price)) {

                        return;
                    }
                    if(isNaN(_realPrice)) {

                        return;
                    }


                    $.post("productAction!editProduct.action",{"proId":_proId,"proName":_proName,"price":_price,"realPrice":_realPrice,"typeId":_typeId,"unit":_unit},function(data){

                            var succcess = data.success;
                            var flag = data.flag;


                            if(succcess)
                            {

                                if(flag)
                                {
                                    $('#editProModal').modal('hide');
                                    createAlertMsgMainWin("衣物修改：成功");
                                    refreshTable(_this._proTable);
                                    //_this._proTable.fnReloadAjax(_this._proTable.fnSettings());


                                }
                                else
                                {
                                    $('#editProModal').modal('hide');
                                    createAlertMsgMainWin("衣物修改：失败");
                                }
                            }
                            else
                            {

                                $('#editProModal').modal('hide');
                                createAlertMsgMainWin("衣物修改：失败");
                            }




                    },"json");

                })


            },"json")



        },
        delPro:function(proId){
            var _this = this;
            $.post("productAction!delPro.action",{"proId":proId},function(data){
                var success = data.success;
                var flag = data.flag;


                if(success)
                {

                    if(flag)
                    {
                        closeloading();
                        $('#msgMain_sign').modal('hide');
                        createAlertMsgMainWin("衣物删除：成功");

                        _this._proTable.fnReloadAjax();
                    }
                    else
                    {
                        createAlertMsgMainWin("衣物删除：失败");
                    }



                }
                else
                {

                    createAlertMsgMainWin("衣物删除：失败");
                }


            },"json");




        },
        delProType:function(typeId){
            var _this = this;
            $.post("productAction!delProType.action",{"typeId":typeId},function(data){
                var success = data.success;
                var flag = data.flag;


                if(success)
                {

                    if(flag)
                    {
                        closeloading();
                        $('#msgMain_sign').modal('hide');
                        createAlertMsgMainWin("衣物类型删除：成功");

                        _this._proTypeTable.fnReloadAjax();
                    }
                    else
                    {
                        createAlertMsgMainWin("衣物类型删除：失败");
                    }



                }
                else
                {

                    createAlertMsgMainWin("衣物类型删除：失败");
                }


            },"json");




        },
        queryAttr:function(proId){

            var _this = this;
            $("#js_addProAttr_ProId").val(proId);
            _this._attrTable = $('#attTable').dataTable({
                "search": false,
                "bDestroy": true,
                "bRetrieve": true,
                "bStateSave": true,
                "aoColumns": [
                    {"mDataProp": "attrId", "sClass": "hidden-480", "bSortable": true, "mData": "attrId"},
                    {"bSortable": false, "mDataProp": "attrName", "sClass": "hidden-480", "mData": "attrName"},
                    {
                        "bSortable": false,
                        "mRender": function (data, type, row) {

                            return '<button class="btn" onclick="Product.editProAttr('+data+')"  ><i class="icon-edit"   alt="修改"></i></button> <button class="btn"  onclick="createMsgMainWin(\'确认删除这条记录吗?\',function(){Product.delProAttr(' + data + ');});" ><i class="icon-remove"  alt="删除"></i></button>  ';
                        },

                        "sClass": "hidden-480 center", "mDataProp": "attrId", "mData": "attrId"
                    }


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
                sAjaxSource: "productAction!queryProAttr.action?proId="+proId,
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

                $("#attrList").css("display","block");
                $("#proList").css("display","none");


        }



    };


}();