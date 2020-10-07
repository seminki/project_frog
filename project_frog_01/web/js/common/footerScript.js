let footerSocialIcons= $(".footer-social-icons>i");
			footerSocialIcons.hover(e=>{
				$(e.target).addClass("animate__heartBeat");
			},e=>{
				$(e.target).removeClass("animate__heartBeat");
			})