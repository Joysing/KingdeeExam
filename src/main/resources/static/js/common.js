/**
 * 公共Ajax方法 提交JSON
 */
var ajaxConfigJSON = {
	type : "POST",
	dataType : "json",
	contentType : 'application/json',
	async : false,
};
function ajaxSubmitJSON(url, data, successFn, errorFn) {
	ajaxConfigJSON.url = url;
	if (data != null) {
		ajaxConfigJSON.data = data;
	}
	;
	ajaxConfigJSON.success = function(data) {
		successFn(data);
	};
	ajaxConfigJSON.error = function(data) {
		errorFn(data);
	};
	$.ajax(ajaxConfigJSON);
};

/**
 * 提交表单
 */
var ajaxConfig = {
	type : "POST",
	dataType : "json",
	async : false,
};
function ajaxSubmit(url, data, successFn, errorFn) {
	ajaxConfig.url = url;
	if (data != null) {
		ajaxConfig.data = data;
	}
	;
	ajaxConfig.success = function(data) {
		successFn(data);
	};
	ajaxConfig.error = function(data) {
		errorFn(data);
	};
	$.ajax(ajaxConfig);
};

/* 提示插件配置 */
toastr.options = {
  "closeButton": true,
  "debug": false,
  "progressBar": false,
  "positionClass": "toast-top-right",
  "onclick": null,
  "showDuration": "300",
  "hideDuration": "1000",
  "timeOut": "5000",
  "extendedTimeOut": "1000",
  "showEasing": "swing",
  "hideEasing": "linear",
  "showMethod": "fadeIn",
  "hideMethod": "fadeOut"
};

String.prototype.format = function() {
    var newStr = this, i = 0;
    while (/%s/.test(newStr)) {
        newStr = newStr.replace("%s", arguments[i++])
    }
    return newStr;
}