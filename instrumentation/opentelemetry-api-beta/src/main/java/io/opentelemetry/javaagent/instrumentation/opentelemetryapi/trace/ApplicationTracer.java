/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.javaagent.instrumentation.opentelemetryapi.trace;

import application.io.opentelemetry.trace.Span;
import application.io.opentelemetry.trace.Tracer;

class ApplicationTracer implements Tracer {

  private final io.opentelemetry.trace.Tracer agentTracer;

  ApplicationTracer(io.opentelemetry.trace.Tracer agentTracer) {
    this.agentTracer = agentTracer;
  }

  @Override
  public Span.Builder spanBuilder(String spanName) {
    return new ApplicationSpan.Builder(agentTracer.spanBuilder(spanName));
  }
}
