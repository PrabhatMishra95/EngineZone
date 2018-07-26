<%@include file="navbar.jsp"%>

<
<style>
.img {
	position: relative;
	float: left;
	width: 900px;
	height: 500px;
	background-position: 50% 50%;
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
<!-- Page Content -->
<div class="container">

	<div class="row">

		<div class="col-lg-3">

			<h1 class="my-4">EngineZone</h1>

		</div>
		<!-- /.col-lg-3 -->

		<div class="col-lg-9">

			<div id="carouselExampleIndicators" class="carousel slide my-4"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carouselExampleIndicators" data-slide-to="0"
						class="active"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="4"></li>

				</ol>
				<div class="carousel-inner" role="listbox">
					<div class="carousel-item active">
						<img class="img" src="resources/images/piston.jpeg"
							alt="First slide">
					</div>
					<div class="carousel-item">
						<img class="img" src="resources/images/connectingrod.jpeg"
							alt="Second slide">
					</div>
					<div class="carousel-item">
						<img class="img" src="resources/images/2.jpg" alt="Third slide">
					</div>
					<div class="carousel-item">
						<img class="img" src="resources/images/camshaft.jpg"
							alt="Fourth slide">
					</div>
					<div class="carousel-item">
						<img class="img" src="resources/images/ford engine.jpg"
							alt="Fifth slide">
					</div>
				</div>
				<a class="carousel-control-prev" href="#carouselExampleIndicators"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>


		</div>
		<!-- /.col-lg-9 -->

	</div>
	<!-- /.row -->

</div>
<!-- /.container -->

<%@include file="footer.jsp"%>