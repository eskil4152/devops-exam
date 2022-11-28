resource "aws_cloudwatch_metric_alarm" "many_carts" {
  alarm_name          = "Threshold for over 5 carts -- ${var.candidate_id}"
  namespace           = var.candidate_id
  metric_name         = "carts.value"

  comparison_operator = "GreaterThanThreshold"
  threshold           = "5"
  evaluation_periods  = "3"
  period = "300"

  statistic = "Maximum"

  alarm_description = "Alarm goes off 5+ carts are registered in a 5 minute period 3 times"
  insufficient_data_actions = []
  alarm_actions = [aws_sns_topic.alarms.arn]
}