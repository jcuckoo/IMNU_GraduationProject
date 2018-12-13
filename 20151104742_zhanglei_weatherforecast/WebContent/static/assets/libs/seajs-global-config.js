seajs.config({
	alias: {
		'jquery': 'jquery/1.11.2/jquery',
		'$': 'jquery/1.11.2/jquery',
		'$-debug': 'jquery/1.11.2/jquery',
		"jquery.form": "jquery-plugin/form/3.44.0/form",
		"jquery.jcrop": "jquery-plugin/jcrop/0.9.12/jcrop",
		"jquery.jcrop-css": "jquery-plugin/jcrop/0.9.12/jcrop.css",
		'jquery.bootstrap-datetimepicker': "jquery-plugin/bootstrap-datetimepicker/1.0.0/datetimepicker",
		"plupload": "jquery-plugin/plupload-queue/2.0.0/plupload",
		'bootstrap': 'gallery/bootstrap/3.1.1/bootstrap',
		'echo.js': 'echo.js/1.7.0/index',
		'autocomplete': 'arale/autocomplete/1.2.2/autocomplete',
		'upload': 'arale/upload/1.1.0/upload',
		'bootstrap.validator': 'common/validator',
		'class': 'arale/class/1.1.0/class',
		'base': 'arale/base/1.1.1/base',
		'widget': 'arale/widget/1.1.1/widget',
		'position' : 'arale/position/1.0.1/position',
		'placeholder': 'arale/placeholder/1.1.0/placeholder',
		'webuploader': 'gallery/webuploader/0.1.2/webuploader',
		'ckeditor': 'ckeditor/4.6.7/ckeditor',
		'edusoho.linkselect': 'edusoho/linkselect/1.0/linkselect-debug.js',
		'edusoho.chunkupload': 'edusoho/chunkupload/1.0.1/chunk-upload.js',
		'edusoho.uploadpanel': 'edusoho/uploadpanel/1.0/upload-panel.js',
		'edusoho.uploadProgressBar': 'edusoho/uploadprogressbar/1.0/upload-progress-bar.js',
		'edusoho.webuploader': 'edusoho/webuploader/1.0.1/web-uploader.js',
		'edusoho.imagecrop': 'edusoho/imagecrop/1.0.0/image-crop.js',
		'messenger': 'arale/messenger/2.0.0/messenger',
	},

	// 预加载项
	preload: [this.JSON ? '' : 'json'],

	// 路径配置
	paths: app.jsPaths,

	// 变量配置
	vars: {
		'locale': 'zh-cn'
	},

	charset: 'utf-8',

	debug: app.debug
});

var __SEAJS_FILE_VERSION = '?v' + app.version;

seajs.on('fetch', function(data) {
	if (!data.uri) {
		return ;
	}

	if (data.uri.indexOf(app.mainScript) > 0) {
		return ;
	}

    if (/\:\/\/.*?\/assets\/libs\/[^(common)]/.test(data.uri)) {
        return ;
    }

    data.requestUri = data.uri + __SEAJS_FILE_VERSION;

});

seajs.on('define', function(data) {
	if (data.uri.lastIndexOf(__SEAJS_FILE_VERSION) > 0) {
	    data.uri = data.uri.replace(__SEAJS_FILE_VERSION, '');
	}
});