/*
 * 实现抛物线函数 Parabola
 * 切记既然是抛物线运动，那么运动的元素需要绝对定位
 * 具体了解抛物线 可以看张鑫旭的文章 
 * http://www.zhangxinxu.com/wordpress/2013/12/javascript-js-%E5%85%83%E7%B4%A0-%E6%8A%9B%E7%89%A9%E7%BA%BF-%E8%BF%90%E5%8A%A8-%E5%8A%A8%E7%94%BB/
 */
var Parabola = function(opts){
	this.init(opts);
};
Parabola.prototype = {
	constructor: Parabola,
	/*
	 * @fileoverview 页面初始化
	 * @param opts {Object} 配置参数
	 */
	init: function(opts){
		this.opts =  $.extend(defaultConfig, opts || {});
		// 如果没有运动的元素 直接return
		if(!this.opts.el) {
			return;
		}
		// 取元素 及 left top
		this.$el = $(this.opts.el);
		this.$elLeft = this._toInteger(this.$el.css("left"));
		this.$elTop = this._toInteger(this.$el.css("top"));
		// 计算x轴，y轴的偏移量
		if(this.opts.targetEl) {
			this.diffX = this._toInteger($(this.opts.targetEl).css("left")) - this.$elLeft;
			this.diffY = this._toInteger($(this.opts.targetEl).css("top")) - this.$elTop;
		}else {
			this.diffX = this.opts.offset[0];
			this.diffY = this.opts.offset[1];
		}
		// 运动时间
		this.duration = this.opts.duration;
		// 抛物线曲率
		this.curvature = this.opts.curvature;
		
		// 计时器
		this.timerId = null;
		/*
		 * 根据两点坐标以及曲率确定运动曲线函数（也就是确定a, b的值）
		 * 公式： y = a*x*x + b*x + c;
		 * 因为经过(0, 0), 因此c = 0
         * 于是：
         * y = a * x*x + b*x;
         * y1 = a * x1*x1 + b*x1;
         * y2 = a * x2*x2 + b*x2;
         * 利用第二个坐标：
         * b = (y2 - a*x2*x2) / x2
		 */
		 this.b = (this.diffY - this.curvature * this.diffX * this.diffX) / this.diffX;

		 // 是否自动运动
		 if(this.opts.autostart) {
			 this.start();
		 }
	},
	/*
	 * @fileoverview 开始
	 */
	start: function(){
		// 开始运动
		var self = this;
		// 设置起始时间 和 结束时间
		this.begin = (new Date()).getTime();
		this.end = this.begin + this.duration;
		
		// 如果目标的距离为0的话 就什么不做
		if(this.diffX === 0 && this.diffY === 0) {
			return;
		}
		if(!!this.timerId) {
			clearInterval(this.timerId);
			this.stop();
		}
		// 每帧（对于大部分显示屏）大约16~17毫秒。默认大小是166.67。也就是默认10px/ms
		this.timerId = setInterval(function(){
			var t = (new Date()).getTime();
			self.step(t);
		},16);
		return this;
	},
	/*
	 * @fileoverview 执行每一步
	 * @param {string} t 时间
	 */
	step: function(t){
		var opts = this.opts;
		var x,
			y;
		// 如果当前运行的时间大于结束的时间
		if(t > this.end) {
			// 运行结束
			x = this.diffX;
			y = this.diffY;
			this.move(x,y);
			this.stop();
			// 结束后 回调
			if(typeof opts.callback === 'function') {
				opts.callback.call(this);
			}
		}else {
			// 每一步x轴的位置
			x = this.diffX * ((t - this.begin) / this.duration);
			// 每一步y轴的位置 y = a * x *x + b*x + c; c = 0
			y = this.curvature * x * x + this.b * x;
			// 移动
			this.move(x,y);
			if(typeof opts.stepCallback === 'function') {
				opts.stepCallback.call(this,x,y);
			}
		}
		return this;
	},
	/*
	 * @fileoverview 给元素定位
	 * @param {x,y} x,y坐标
	 * @return this
	 */
	move: function(x,y) {
		this.$el.css({
			"position":'absolute',
			"left": this.$elLeft + x + 'px',
			"top": this.$elTop + y + 'px'
		});
		return this;
	},
	/*
	 * 获取配置项
	 * @param {object} options配置参数
	 * @return {object} 返回配置参数项
	 */
	getOptions: function(options){
		if(typeof options !== "object") {
			options = {};
		}
		options = $.extend(defaultConfig, options || {});
		return options;
	},
	/*
	 * 设置options
	 * @param options
	 */
	setOptions: function(options) {
		this.reset();
		if(typeof options !== 'object') {
			options = {};
		}
		options = $.extend(this.opts,options);
		this.init(options);
		return this;
	},
	/*
	 * 重置
	 */
	reset: function(x,y) {
		this.stop();
		x = x ? x : 0;
		y = y ? y : 0;
		this.move(x,y);
		return this;
	},
	/*
	 * 停止
	 */
	stop: function(){
		if(!!this.timerId){
			clearInterval(this.timerId);
		}
		return this;
	},
	/*
	 * 变成整数
	 * isFinite() 函数用于检查其参数是否是无穷大。
	 */
	_toInteger: function(text){
		text = parseInt(text);
        return isFinite(text) ? text : 0;
	}
};
var defaultConfig = {
	//需要运动的元素 {object | string}
	el: null,

	// 运动的元素在 X轴，Y轴的偏移位置
	offset: [0,0],

	// 终点元素 
	targetEl: null,

	// 运动时间，默认为500毫秒
	duration: 500,

	// 抛物线曲率，就是弯曲的程度，越接近于0越像直线，默认0.001
	curvature: 0.01,
	
	// 运动后执行的回调函数
	callback: null,

	// 是否自动开始运动，默认为false
	autostart: false,
	
	// 运动过程中执行的回调函数，this指向该对象，接受x，y参数，分别表示X，Y轴的偏移位置。
	stepCallback: null
};