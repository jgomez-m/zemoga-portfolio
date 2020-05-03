<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <title>Portfolio Web</title>

    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <style>
        body {
            padding-top: 30px;
        }

        .glyphicon {
            margin-bottom: 10px;
            margin-right: 10px;
        }

        small {
            display: block;
            line-height: 1.428571429;
            color: #999;
        }
    </style>
</head>
<body>


<div class="container">
    <div class="row">
        <div>
            <div>
                <div class="row">
                    <div>
                        <img src="${userPortfolio.portfolio.imageUrl}" alt="" class="img-rounded img-responsive"/>
                    </div>
                    <div>
                        <h4>${userPortfolio.portfolio.title}</h4>
                        <p>${userPortfolio.portfolio.description}</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div>
            <div>
                <div class="row">
                    <div>
                        <h4>${userPortfolio.portfolio.title}'s Timeline</h4>
                    </div>
                    <div>
                        <ul class="list-group">
                            <c:forEach var="tweet" items="${userPortfolio.tweets}">
                                <li class="list-group-item"><b><small>${tweet.fromUser} - ${tweet.createdAt} </small> </b> ${tweet.text}</li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>

